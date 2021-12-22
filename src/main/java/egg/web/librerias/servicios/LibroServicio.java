package egg.web.librerias.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egg.web.librerias.entidades.Autor;
import egg.web.librerias.entidades.Editorial;
import egg.web.librerias.entidades.Libro;
import egg.web.librerias.repositorios.LibroRepositorio;

@Service
public class LibroServicio {
  
@Autowired
private LibroRepositorio libroRepositorio;

@Transactional
public Libro crearLibro(long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor,Editorial editorial) throws Exception{
	
	try {
	Libro libro = new Libro();
	libro.setAlta(true);
	libro.setIsbn(isbn);
	libro.setTitulo(titulo);
	libro.setAnio(anio);
	libro.setEjemplares(ejemplares);
	libro.setAutor(autor);
	libro.setEditorial(editorial);
	
	libroRepositorio.save(libro);
	return libro;
	}catch(Exception e) {
		
	throw new Exception();
	}
	
	
}

@Transactional
public Libro editarLibro(String id,long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor,Editorial editorial )throws Exception {
	
	try {
Optional<Libro> modificar = libroRepositorio.findById(id);


Libro libro = modificar.get();
libro.setIsbn(isbn);
libro.setTitulo(titulo);
libro.setAnio(anio);
libro.setEjemplares(ejemplares);
libro.setAutor(autor);
libro.setEditorial(editorial);

libroRepositorio.save(libro);
return libro;

}catch(Exception e) {
throw new Exception();
}
	
}


@Transactional
public Optional<Libro> buscarLibroPorID(String id) throws Exception {
	try {
	Optional<Libro> buscar = libroRepositorio.findById(id);
	return buscar;
}catch(Exception e) {
	throw new Exception();	
}
}



@Transactional
public List<Libro> buscarLibro() throws Exception {
	List<Libro> libro = libroRepositorio.findAll();
	
	return libro;
}

@Transactional
public Libro libroBaja(String id) throws Exception  {
	
	try {
Optional<Libro> modificar = libroRepositorio.findById(id);

Libro libro = modificar.get();
libro.setAlta(false);

libroRepositorio.save(libro);
return libro;
	}catch(Exception e) {
		throw new Exception();
	}
}


@Transactional
public Libro libroActivo(String id)throws Exception  {
	
	try {
Optional<Libro> modificar = libroRepositorio.findById(id);

Libro libro = modificar.get();
libro.setAlta(true);

libroRepositorio.save(libro);
return libro;
	}catch(Exception e) {
	throw new Exception();
	}
}

}
