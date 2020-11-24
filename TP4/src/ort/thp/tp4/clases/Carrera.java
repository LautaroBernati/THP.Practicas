package ort.thp.tp4.clases;

import java.util.ArrayList;
import java.util.Random;

public class Carrera {
	private final int MINIMO_DE_VUELTAS=10;
	
	private String fecha;//identificador
	private String hora;
	private Dificultad dificultad;
	private ArrayList<Piloto> pilotos;
	private int cantVueltas;
	private boolean estaRealizada;
	
	
	
	public boolean correr(){
		boolean ok=false;
		int azar=0;
		Random rand=new Random();
		//foreach
		for(Piloto piloto:this.pilotos){
			azar=rand.nextInt(this.cantVueltas)+1;//deberia darme un int entre 1 y cantVueltas
			piloto.correrVueltas(azar);
			
			
			
			this.setEstaRealizada(true);
		}
		return ok;
	}
	
	public int mostrarPilotos(){
		return this.pilotos.size();
	}
	
	public boolean cargarPiloto(String nombre, String dni){
		boolean ok=false;
		Piloto piloto=null;
		piloto=buscarPiloto(dni);
		if(piloto==null){
			piloto=new Piloto(nombre, dni);
			this.pilotos.add(piloto);
			ok=true;
		}		
		return ok;
	}
	
	private Piloto buscarPiloto(String dni){
		int i=0;
		Piloto pilotoEncontrado=null;
		while(i<this.pilotos.size() && pilotoEncontrado==null){
			if(this.pilotos.get(i).mostrarDni()==dni){
				pilotoEncontrado=this.pilotos.get(i);
			}
			i++;
		}
		return pilotoEncontrado;
	}
	
	public InfoCarrera obtenerInfoCarrera(){
		InfoCarrera info=new InfoCarrera(this.fecha, this.hora, this.dificultad, this.pilotos.size());
		return info;
	}
	
	public void mostrarMenorPromedio(){
		double candidatoMin=90;//setteo en un valor que siempre sea negativo a la hora de comparar mas abajo...
		Piloto pilotoMenor=null;
		for(Piloto piloto:this.pilotos){
			if(piloto.calcularVueltaPromedio()<candidatoMin){
				candidatoMin=piloto.calcularVueltaPromedio();
				pilotoMenor=piloto;
			}
		}
		System.out.println("El menor promedio fue "+pilotoMenor.getNombre()+" "+pilotoMenor.getDni());
		
	}
	
	public ArrayList<Piloto> buscarPilotosPorDebajoDe(double promedioDeTiempo){
		ArrayList<Piloto> promediados=new ArrayList<Piloto>();
		
		for(Piloto piloto:this.pilotos){
			if(piloto.mostrarVueltasRealizadas()>MINIMO_DE_VUELTAS){
				if(piloto.calcularVueltaPromedio()<promedioDeTiempo){
					promediados.add(piloto);
				}
			}
		}
		return promediados;
	}
	
	//<<<<<>>>>>
	public Carrera(String fecha, String hora, Dificultad dificultad, int cantVueltas) {
		this.setFecha(fecha);
		this.setHora(hora);
		this.setDificultad(dificultad);
		this.setCantVueltas(cantVueltas);
		this.pilotos=new ArrayList<Piloto>();
		this.setEstaRealizada(false);
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Dificultad getDificultad() {
		return dificultad;
	}
	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	public int getCantVueltas() {
		return cantVueltas;
	}
	public void setCantVueltas(int cantVueltas) {
		this.cantVueltas = cantVueltas;
	}
	public boolean isEstaRealizada() {
		return estaRealizada;
	}
	private void setEstaRealizada(boolean estaRealizada) {
		this.estaRealizada = estaRealizada;
	}

	@Override
	public String toString() {
		return "Carrera [fecha=" + fecha + ", hora=" + hora + ", dificultad=" + dificultad + ", pilotos=" + pilotos
				+ ", cantVueltasDeLaCarrera=" + cantVueltas + ", estaRealizada=" + estaRealizada + "]";
	}
}
