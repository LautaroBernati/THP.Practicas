package ort.thp.tp4.clases;

public class InfoCarrera {
	
	public String fechaCarrera;
	public String horaCarrera;
	public Dificultad dificultadCarrera;
	public int cantidadDePilotos;
	
	
	public InfoCarrera(String fechaCarrera, String horaCarrera, Dificultad dificultadCarrera, int cantidadDePilotos) {
		super();
		this.setFechaCarrera(fechaCarrera);
		this.setHoraCarrera(horaCarrera);
		this.setDificultadCarrera(dificultadCarrera);
		this.setCantidadDePilotos(cantidadDePilotos);
	}
	public String getFechaCarrera() {
		return fechaCarrera;
	}
	public void setFechaCarrera(String fechaCarrera) {
		this.fechaCarrera = fechaCarrera;
	}
	public String getHoraCarrera() {
		return horaCarrera;
	}
	public void setHoraCarrera(String horaCarrera) {
		this.horaCarrera = horaCarrera;
	}
	public Dificultad getDificultadCarrera() {
		return dificultadCarrera;
	}
	public void setDificultadCarrera(Dificultad dificultadCarrera) {
		this.dificultadCarrera = dificultadCarrera;
	}
	public int getCantidadDePilotos() {
		return cantidadDePilotos;
	}
	public void setCantidadDePilotos(int cantidadDePilotos) {
		this.cantidadDePilotos = cantidadDePilotos;
	}
	@Override
	public String toString() {
		return "InfoCarrera [fechaCarrera=" + fechaCarrera + ", horaCarrera=" + horaCarrera + ", dificultadCarrera="
				+ dificultadCarrera + ", cantidadDePilotos=" + cantidadDePilotos + "]";
	}
}
