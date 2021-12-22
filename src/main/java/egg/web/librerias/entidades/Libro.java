package egg.web.librerias.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity

public class Libro {
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid" , strategy="uuid2")
	private String id;
	
	private long isbn;
	private String titulo;
	private Integer anio;
	private Integer ejemplares;
	private Integer ejemplaresPrestado;

	private Integer ejemplaresRestante;
	private Boolean alta;
	
    @OneToOne
    private Editorial editorial;
    @OneToOne
	private Autor autor;
	
	
	
	public Libro() {
		
	}
	
	public Libro(String id, long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestado,
			Integer ejemplaresRestante, boolean alta, Autor autor, Editorial editorial) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.anio = anio;
		this.ejemplares = ejemplares;
		this.ejemplaresPrestado = ejemplaresPrestado;
		this.ejemplaresRestante = ejemplaresRestante;
		this.alta = alta;
		this.autor = autor;
		this.editorial = editorial;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}
	public Integer getEjemplaresPrestado() {
		return ejemplaresPrestado;
	}
	public void setEjemplaresPrestado(Integer ejemplaresPrestado) {
		this.ejemplaresPrestado = ejemplaresPrestado;
	}
	public Integer getEjemplaresRestante() {
		return ejemplaresRestante;
	}
	public void setEjemplaresRestante(Integer ejemplaresRestante) {
		this.ejemplaresRestante = ejemplaresRestante;
	}
	public boolean isAlta() {
		return alta;
	}
	public void setAlta(boolean alta) {
		this.alta = alta;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}
	
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	
	

}
