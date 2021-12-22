package egg.web.librerias.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egg.web.librerias.entidades.Autor;
import egg.web.librerias.repositorios.AutorRepositorio;

@Service
public class AutorServicio {
	
   @Autowired
	private AutorRepositorio autorRepositorio;
	
	@Transactional
	public Autor crearAutor(String nombre) { 
	   Autor autor = new Autor();
	   
	   autor.setNombre(nombre);
	   autor.setAlta(true); 
	   
	   autorRepositorio.save(autor);
	    return autor;
	}
	
	
	@Transactional
	public Autor editarAutorNombre(String id, String nombre) {
		
	Optional<Autor> modificar = autorRepositorio.findById(id);
	
	Autor autor = modificar.get();
	autor.setNombre(nombre);
	
	autorRepositorio.save(autor);
	return autor;
	}
	
	@Transactional
	public Autor autorBaja(String id) {
		
	Optional<Autor> modificar = autorRepositorio.findById(id);
	
	Autor autor = modificar.get();
	autor.setAlta(false);
	
	autorRepositorio.save(autor);
	return autor;
	}
	
	
	@Transactional
	public Autor autorActivo(String id) {
		
	Optional<Autor> modificar = autorRepositorio.findById(id);
	
	Autor autor = modificar.get();
	autor.setAlta(true);
	
	autorRepositorio.save(autor);
	return autor;
	}
	
	
	@Transactional
	public Optional<Autor> buscarAutorPorID(String id){
		Optional<Autor> buscar = autorRepositorio.findById(id);
		return buscar;
	}
	
	 @Transactional
	public List<Autor> buscarAutor(){
		List<Autor> autores = autorRepositorio.findAll();
		
		return autores;
	}

	 @Transactional
		public List<Autor> buscarAutorActivo(){
			List<Autor> autores = autorRepositorio.buscarAutorActivo();
			
			return autores;
		}

	 @Transactional
		public List<Autor> buscarAutorInactivo(){
			List<Autor> autores = autorRepositorio.buscarAutorInactivo();
			
			return autores;
		}
	
	
	
}
