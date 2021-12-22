package egg.web.librerias.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import egg.web.librerias.entidades.Autor;


@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
	
	 @Query("SELECT a FROM Autor a WHERE a.alta = true")
	public List<Autor> buscarAutorActivo();
	
	@Query("SELECT a FROM Autor a WHERE a.alta = false")
	public List<Autor> buscarAutorInactivo(); 
}
