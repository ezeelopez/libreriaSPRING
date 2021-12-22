package egg.web.librerias.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egg.web.librerias.entidades.Autor;
import egg.web.librerias.entidades.Editorial;
import egg.web.librerias.entidades.Libro;
import egg.web.librerias.servicios.AutorServicio;
import egg.web.librerias.servicios.EditorialServicio;
import egg.web.librerias.servicios.LibroServicio;

@Controller
@RequestMapping("/libro")
public class libroControlador {
	
	@Autowired
	private LibroServicio libroServicio;
	@Autowired
	private AutorServicio autorServicio;
	@Autowired
	private EditorialServicio editorialServicio;

	@GetMapping("/ver-libro")
    public ModelAndView buscarlibro() throws Exception{
        
        ModelAndView mav = new ModelAndView("/libro-lista");
        List<Libro> libro = libroServicio.buscarLibro();
        mav.addObject("libro", libro);
        return mav;
    }
	


	@GetMapping("/crear-libro")
	public String crearLibro( ModelMap modelo)throws Exception {
		List<Autor> autor = autorServicio.buscarAutor();
		List<Editorial> editorial = editorialServicio.buscarEditorial();
		modelo.addAttribute("autor", autor);
		modelo.addAttribute("editorial", editorial);
		
		return ("/libro-formulario");
	}
	
	 @PostMapping("/guardar-libro")
	 public String crearLibro(@RequestParam long isbn, @RequestParam String titulo,
			 @RequestParam Integer anio
			 , @RequestParam("autor") Autor autor, @RequestParam("editorial") Editorial editorial ) {
		 
		 try {
	  libroServicio.crearLibro(isbn, titulo, anio, null, autor, editorial);
		 
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }
		  return "redirect:/libro/ver-libro";

	 }
	 
	 @GetMapping("/modificar-libro")
	 public String modificarFormulario(@RequestParam String id, ModelMap model) throws Exception {
		 
		 Libro libro = libroServicio.buscarLibroPorID(id).get();
		 List<Autor> autor = autorServicio.buscarAutor();
		 List<Editorial> editorial = editorialServicio.buscarEditorial();
		 model.addAttribute("autor", autor);
	     model.addAttribute("editorial", editorial);
		 model.addAttribute("libro", libro);
		 
		 return "/libro-modificar";
	 }
	
	 @PostMapping("/editar-libro")
	 public String modificarLibro(@RequestParam String id,@RequestParam long isbn ,@RequestParam String titulo, @RequestParam Integer anio
			 , @RequestParam("autor") Autor autor, @RequestParam("editorial") Editorial editorial ) throws Exception {
		 
		 libroServicio.editarLibro(id, isbn, titulo, anio, anio, autor, editorial);
		 
		 try {
			 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/libro/ver-libro/";
	 }
	 
	/* @GetMapping("/bajar-libro")
	 public String bajarLibro(@RequestParam String id, ModelMap model) throws Exception{
		 
		 Libro libro = libroServicio.buscarLibroPorID(id).get();
		 model.addAttribute("libro", libro);
		 return "/libro-bajar";
	 } */
	 
	 @GetMapping("/baja-libro/{id}")
	 public String bajaEditorial( @PathVariable("id") String id) {
		 
		 try {
			
		libroServicio.libroBaja(id);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/libro/ver-libro/";
	 }

	 
	 @GetMapping("/activar-libro/{id}")
	 public String activarAutor( @PathVariable("id")String id) {
		 
		 try {
			 
		 libroServicio.libroActivo(id);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/libro/ver-libro/";
	 
	 }
	 
}
