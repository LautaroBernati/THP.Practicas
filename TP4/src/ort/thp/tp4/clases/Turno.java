package ort.thp.tp4.clases;

public class Turno {
	
	private Paciente paciente;
	private boolean presencia;
	
	public boolean estaPresente(){
		return this.presencia;
	}
	public Paciente mostrarPaciente(){
		return this.paciente;
	}
	//<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>
	public Turno(String dni, String nombre, String apellido, String telefono){
		this.paciente=new Paciente(dni, nombre, apellido, telefono);
		this.setPresencia(false);
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public boolean isPresencia() {
		return presencia;
	}
	public void setPresencia(boolean presencia) {
		this.presencia = presencia;
	}

	@Override
	public String toString() {
		return "Turno [paciente=" + paciente + ", presencia=" + presencia + "]";
	}
}
