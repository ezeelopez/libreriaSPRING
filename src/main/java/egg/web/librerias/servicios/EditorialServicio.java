package egg.web.librerias.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import egg.web.librerias.entidades.Editorial;
import egg.web.librerias.repositorios.EditorialRepositorio;

@Service
public class EditorialServicio {
	
	@Autowired
	private EditorialRepositorio editorialRepositorio;
   
	@Transactional
	public Editorial crearEditorial(String nombre) throws Exception {
		
		Editorial editorial = new Editorial();
		editorial.setNombre(nombre);
		editorial.setAlta(true);
		
		editorialRepositorio.save(editorial);
		
		return editorial;
	}
	
	@Transactional
	public Editorial editarEditorialNombre(String id, String nombre)throws Exception {
		
		try {
	Optional<Editorial> modificar = editorialRepositorio.findById(id);
	
	Editorial editorial = modificar.get();
	editorial.setNombre(nombre);
	
	editorialRepositorio.save(editorial);
	return editorial;
		}catch(Exception e) {
			throw new Exception();
		}
	}
	
	
	
	@Transactional
	public Optional<Editorial> buscarEditorialPorID(String id)throws Exception {
	  try {
		Optional<Editorial> buscar = editorialRepositorio.findById(id);
		
		
		return buscar;
	  }catch(Exception e) {
			throw new Exception();
		}
	}
	
	
	
	@Transactional
	public List<Editorial> buscarEditorial()throws Exception {
		try {
		List<Editorial> editorial = editorialRepositorio.findAll();
		
		return editorial;
	}catch(Exception e) {
		throw new Exception();
	}
	}
	
	@Transactional
	public Editorial editorialBaja(String id)throws Exception {
		try {
	Optional<Editorial> modificar = editorialRepositorio.findById(id);
	
	Editorial editorial = modificar.get();
	editorial.setAlta(false);
	
	editorialRepositorio.save(editorial);
	return editorial;
	}catch(Exception e) {
		throw new Exception();
	}
	}
	
	@Transactional
	public Editorial editorialActivo(String id)throws Exception {
		try {
	Optional<Editorial> modificar = editorialRepositorio.findById(id);
	
	Editorial editorial = modificar.get();
	editorial.setAlta(true);
	
	editorialRepositorio.save(editorial);
	return editorial;
	}catch(Exception e) {
		throw new Exception();
	}
	}
		
	
}
