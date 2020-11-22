package ort.thp.tp4.clases;

import java.util.ArrayList;

public class Usuario {
	
	private String email;
	private String apellido;
	private int edad;
	private Categoria categoria;
	private ArrayList<Cancion> cancionesEscuchadas;
	
	public void mostrarCancionesEscuchadas(){
		System.out.println(this.cancionesEscuchadas);
	}
	
	public int cantCancionesEscuchadas(){
		return cancionesEscuchadas.size();
	}
	
	public boolean agregarCancionEscuchada(Cancion cancion){
		boolean ok=false;
		if(cancion!=null){
			this.cancionesEscuchadas.add(cancion);
			ok=true;
		}
		return ok;
	}
	
	public String emailUsuario(){
		return this.email;
	}
	
	//<<<<<<>>>>>>
	public Usuario(String email, String apellido, int edad, Categoria categoria) {
		this.setEmail(email);
		this.setApellido(apellido);
		this.setEdad(edad);
		this.setCategoria(categoria);
		this.cancionesEscuchadas = new ArrayList<Cancion>();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", apellido=" + apellido + ", edad=" + edad + ", categoria=" + categoria
				+ " , TotalEscuchadas="+this.cancionesEscuchadas.size()+ ", cancionesEscuchadas=" + cancionesEscuchadas +"]";
	}
	/*private Cancion buscarCancion(Cancion cancion){ //polemic
	Cancion cancionEncontrada=null;
	int i=0;
	
	while(i<this.cancionesEscuchadas.size() && cancionEncontrada==null){
		if(this.cancionesEscuchadas.get(i).nombreCancion() == cancion.nombreCancion()){
			cancionEncontrada=this.cancionesEscuchadas.get(i);
		}
		i++;
	}
	return cancionEncontrada;
}*/
}
