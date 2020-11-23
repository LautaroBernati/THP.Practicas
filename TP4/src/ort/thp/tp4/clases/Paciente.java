package ort.thp.tp4.clases;

public class Paciente {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	
	public String mostrarDniPaciente(){
		return this.dni;
	}
	
	//<<<<<<>>>>>>
	
	public String getDni() {
		return dni;
	}
	public Paciente(String dni, String nombre, String apellido, String telefono) {
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setTelefono(telefono);
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ "]";
	}
}
