package egg.web.librerias.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;


import egg.web.librerias.entidades.Editorial;
//import egg.web.librerias.repositorios.EditorialRepositorio;
import egg.web.librerias.servicios.EditorialServicio;



@Controller
@RequestMapping("/editorial")
public class editorialControlador {
	
	@Autowired
	private EditorialServicio editorialServicio;
	
	
	
	 @GetMapping("/ver-editorial")
	    public ModelAndView buscarEditorial() throws Exception{
	        
	        ModelAndView mav = new ModelAndView("/editorial-lista");
	        List<Editorial> editorial = editorialServicio.buscarEditorial();
	        mav.addObject("editorial", editorial);
	        return mav;
	    }
	 
	 @GetMapping("/crear-editorial")
	 public ModelAndView mostrarFormulario() {
		 return new ModelAndView("/editorial-formulario");
	 }
	 
	 @GetMapping("/modificar-editorial")
	 public String modificarFormulario(@RequestParam String id, ModelMap model)throws Exception {
		 
		 Editorial editorial = editorialServicio.buscarEditorialPorID(id).get();
		 model.addAttribute("editorial", editorial);
		 
		 return "/editorial-modificar";
	 }

	 @PostMapping("/guardar-editorial")
	 public String crearEditorial(@RequestParam String nombre)throws Exception {
		 
		 try {
		 editorialServicio.crearEditorial(nombre);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/editorial/ver-editorial/";

	 }
	 
	 
	 @PostMapping("/editar-editorial")
	 public String modificarEditorial( @RequestParam String id ,@RequestParam String nombre)throws Exception {
		 
		 try {
			 
		 editorialServicio.editarEditorialNombre(id, nombre);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/editorial/ver-editorial/";
	 }
	 

	 
	 @GetMapping("/baja-editorial/{id}")
	 public String bajaEditorial( @PathVariable("id") String id)throws Exception {
		 
		 try {
			 
		 editorialServicio.editorialBaja(id);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/editorial/ver-editorial/";
	 }
	
	 
	 @GetMapping("/activar-editorial/{id}")
	 public String activarAutor( @PathVariable("id") String id)throws Exception {
		 
		 try {
			 
		 editorialServicio.editorialActivo(id);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/editorial/ver-editorial/";
	 
	 }
	 
	 
}
