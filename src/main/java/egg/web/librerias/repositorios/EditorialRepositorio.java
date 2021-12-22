package egg.web.librerias.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import egg.web.librerias.entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String>{
	
	@Query("SELECT a FROM Editorial a WHERE a.alta = true")
	public List<Editorial> buscarEditorialActivo();
	
	@Query("SELECT a FROM Editorial a WHERE a.alta = false")
	public List<Editorial> buscarEditorialInactivo(); 
}
