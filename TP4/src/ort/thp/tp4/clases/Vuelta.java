package ort.thp.tp4.clases;

public class Vuelta {
	
	private int tiempoObtenido; //en segundos

	
	//<<<<<>>>>>>
	public Vuelta(int tiempoObtenido) {
		this.setTiempoObtenido(tiempoObtenido);
	}
	public int getTiempoObtenido() {
		return tiempoObtenido;
	}

	public void setTiempoObtenido(int tiempoObtenido) {
		this.tiempoObtenido = tiempoObtenido;
	}
	@Override
	public String toString() {
		return "Vuelta [tiempoObtenido=" + tiempoObtenido + "]";
	}
}
