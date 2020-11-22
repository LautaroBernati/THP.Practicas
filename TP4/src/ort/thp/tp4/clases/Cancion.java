package ort.thp.tp4.clases;

public class Cancion {
	
	private String nombre;
	private String autor;
	private String genero;
	private int diasDesdePublicacion;
	private int cantidadEscuchada;
	private Categoria categoria;
	
	private final int MINIMO_DE_DIAS=7;
	private final int TOPE_ESCUCHAR=1000;
	
	public String nombreCancion(){
		return this.nombre;
	}
	
	public String nombreAutor(){
		return this.autor;
	}
	public void recalcularCategoria(){
		if(this.cantidadEscuchada>=TOPE_ESCUCHAR || this.diasDesdePublicacion<=MINIMO_DE_DIAS){
			this.categoria=Categoria.PREMIUM;
		}
	}
	
	//<<<<<>>>>>
	
	public Cancion(String nombre, String autor, String genero, int diasDesdePublicacion) {
		this.setNombre(nombre);
		this.setAutor(autor);
		this.setGenero(genero);
		this.setDiasDesdePublicacion(diasDesdePublicacion);
		this.setCantidadEscuchada(0); //supongo debe ser 0?
		this.setCategoria();//debe faltar una logica aca seguramente
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getDiasDesdePublicacion() {
		return diasDesdePublicacion;
	}
	public void setDiasDesdePublicacion(int diasDesdePublicacion) {
		this.diasDesdePublicacion = diasDesdePublicacion;
	}
	public int getCantidadEscuchada() {
		return cantidadEscuchada;
	}
	public void setCantidadEscuchada(int cantidadEscuchada) {
		this.cantidadEscuchada = cantidadEscuchada;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria() {
		if(this.diasDesdePublicacion<=MINIMO_DE_DIAS){
			this.categoria=Categoria.PREMIUM;
		}
		else{
			this.categoria=Categoria.REGISTRADO;
		}
	}
	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", autor=" + autor + ", genero=" + genero + ", diasDesdePublicacion="
				+ diasDesdePublicacion + ", cantidadEscuchada=" + cantidadEscuchada + ", categoria=" + categoria + "]";
	}
}
