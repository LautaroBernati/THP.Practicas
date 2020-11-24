package ort.thp.tp4.clases;

import java.util.ArrayList;
import java.util.Random;

public class Piloto {
	
	private String nombre;
	private String dni;
	private ArrayList<Vuelta> vueltas;
	
	
	
	public boolean correrVueltas(int cantVueltasArealizar){//ver que hacer con el boolean
		boolean ok=false;
		int i=0, azar=0;
		Random rand=new Random();
		Vuelta vuelta=null;
		//cada vuelta sera un random
		while(i<cantVueltasArealizar){
			azar=rand.nextInt(20)+30;//deberia darme un numero entre 30 y 50
			//azar+=30; 
			vuelta=new Vuelta(azar);
			this.vueltas.add(vuelta);
			i++;
		}
		return ok;
	}
	
	
	public int mostrarVueltasRealizadas(){
		return this.vueltas.size();
	}
	
	public double calcularVueltaPromedio(){
		double promedio=0;
		
		for(Vuelta vuelta:this.vueltas){
			promedio=promedio+vuelta.getTiempoObtenido();
		}
		promedio=promedio/this.vueltas.size();
		//System.out.println("El promedio de vueltas del piloto "+this.nombre+" fue de "+promedio+" segundos");
		return promedio;
	}
	
	public String mostrarDni(){
		return this.dni;
	}
	
	//<<<<<>>>>>>
	public Piloto(String nombre, String dni) {
		this.setNombre(nombre);
		this.setDni(dni);
		this.vueltas = new ArrayList<Vuelta>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Piloto [nombre=" + nombre + ", dni=" + dni +" VueltasRealziadas=" + this.vueltas.size()+", vueltas=" + vueltas +"]";
	}
}
