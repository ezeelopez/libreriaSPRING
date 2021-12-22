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

import egg.web.librerias.entidades.Autor;

import egg.web.librerias.servicios.AutorServicio;

@Controller
@RequestMapping("/autor")
public class autorControlador {
	
	@Autowired
	private AutorServicio autorServicio;
	
	
	 @GetMapping("/ver-autor")
	    public ModelAndView buscarautor() throws Exception{
	        
	        ModelAndView mav = new ModelAndView("/autor-lista");
	        List<Autor> autor = autorServicio.buscarAutor();
	        mav.addObject("autor", autor);
	        return mav;
	    } 
	 
	
	 
	 
	 
	 
	 @GetMapping("/ver-autoractivo")
	    public ModelAndView buscarautoractivo() throws Exception{
	        
	        ModelAndView mav = new ModelAndView("/autor-lista-activo");
	        List<Autor> autor = autorServicio.buscarAutorActivo();
	        mav.addObject("autor", autor);
	        return mav;
	    }
	 
	 @GetMapping("/ver-autorinactivo")
	    public ModelAndView buscarautorinactivo() throws Exception{
	        
	        ModelAndView mav = new ModelAndView("/autor-lista-inactivo");
	        List<Autor> autor = autorServicio.buscarAutorInactivo();
	        mav.addObject("autor", autor);
	        return mav;
	    }
	 
	 
	 @GetMapping("/crear-autor")
	 public ModelAndView mostrarFormulario() {
		 return new ModelAndView("/autor-formulario");
	 }

	 @PostMapping("/guardar-autor")
	 public String crearEditorial(@RequestParam String nombre) {
		 
		 try {
		 autorServicio.crearAutor(nombre);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/autor/ver-autor/";
	 }
	 
	 
	 @GetMapping("/modificar-autor")
	 public String modificarFormulario(@RequestParam String id, ModelMap model) {
		 
		 Autor autor = autorServicio.buscarAutorPorID(id).get();
		 model.addAttribute("autor", autor);
		 return "/autor-modificar";
	 }
	 

	 @PostMapping("/editar-autor")
	 public String modificarAutor( @RequestParam String id ,@RequestParam String nombre) {
		 
		 try {
			 
		 autorServicio.editarAutorNombre(id, nombre);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/autor/ver-autor/";
	 
	 }
	 

	 @GetMapping("/baja-autor/{id}")
	 public String bajaAutor( @PathVariable("id") String id) {
		 
		 try {
			 
		 autorServicio.autorBaja(id);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/autor/ver-autor/";
	 }
	 
	 
	 @GetMapping("/activar-autor/{id}")
	 public String activarAutor( @PathVariable String id) {
		 
		 try {
			 
		 autorServicio.autorActivo(id);
		 
		 }catch(Exception e){
			 
		 }
		  return "redirect:/autor/ver-autor/";
	 }
	 
	 
	
	 
}
