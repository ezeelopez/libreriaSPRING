package egg.web.librerias.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import egg.web.librerias.entidades.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {
	
	
	 @Query("SELECT a FROM Libro a WHERE a.alta = true")
	public List<Libro> buscarLibroActivo();
	
	@Query("SELECT a FROM Libro a WHERE a.alta = false")
	public List<Libro> buscarLibroInactivo(); 
	
}
