package ort.thp.tp4.clases;

public class Departamento {

	private int numeroUnidad;
	private Propietario propietario;
	private double deuda;
	
	
	
	public boolean estaHabitado(){
		boolean ok=false;
		if(this.propietario!=null){ //si hay un propietario
			ok=true;
		}
		return ok;
	}
	
	//<<<>>>
	
	
	public Departamento(int numeroUnidad) {
		this.setNumeroUnidad(numeroUnidad);
		this.setPropietario(null);
		this.setDeuda(0);
	}
	public double getDeuda() {
		return deuda;
	}
	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	public Departamento(int numeroUnidad, Propietario propietario) {
		this.setNumeroUnidad(numeroUnidad);//debe ser una unidad de la cantidad total de departamentos
		this.setPropietario(propietario);
	}
	public int getNumeroUnidad() {
		return numeroUnidad;
	}
	public void setNumeroUnidad(int numeroUnidad) {
		this.numeroUnidad = numeroUnidad;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Departamento [numeroUnidad=" + numeroUnidad + ", propietario=" + propietario + ", deuda=" + deuda + "]";
	}
}
