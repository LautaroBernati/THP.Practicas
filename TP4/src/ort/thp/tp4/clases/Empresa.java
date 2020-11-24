package ort.thp.tp4.clases;

import java.util.ArrayList;

public class Empresa {
	
	private String nombreEmpresa;
	ArrayList<Carrera> carreras;
	
	
	//metodos---
	
	public boolean prepararPiloto(String fecha, String nombre, String dni){
		boolean ok=false;
		Carrera carrera=null;
		carrera=buscarCarrera(fecha);
		if(carrera!=null){
			ok=carrera.cargarPiloto(nombre, dni);//esto retorna true/false
		}
		return ok;
	}
	
	public boolean prepararCarrera(String fecha, String hora, Dificultad dificultad, int cantVueltas){
		boolean ok=false;
		if(buscarCarrera(fecha)==null){//si no encontro la carrera de dicha fecha
			Carrera carrera1=new Carrera(fecha, hora, dificultad, cantVueltas);
			this.carreras.add(carrera1);
			ok=true;
		}
		return ok;
	}
	
	public boolean correrCarrera(String fecha){
		boolean ok=false;
		Carrera carrera=null;
		carrera=buscarCarrera(fecha);
		if(carrera!=null){//si la carrera existe...
			if(carrera.mostrarPilotos()>=2){//si hay mas de 2 pilotos registrados
				//pilotos se le ponen vueltas
				carrera.correr();
				carrera.mostrarMenorPromedio();
				ok=true;
			}
		}
		
		return ok;
		
	}
	
	public Carrera buscarCarrera(String fecha){
		Carrera carrera=null;
		int i=0;
		while(i<this.carreras.size() && carrera==null){
			if(this.carreras.get(i).getFecha()==fecha){
				carrera=this.carreras.get(i);
			}
			i++;
		}
		return carrera;
	}
	
	public ArrayList<InfoCarrera> informeResumidoPorCarrera(){
		ArrayList<InfoCarrera>listaCarreras=null;
		if(this.carreras.isEmpty()){
			System.out.println("No hay carreras para mostrar.");
		}
		else{
			listaCarreras=new ArrayList<InfoCarrera>();
			for(Carrera carrera:this.carreras){
				if(carrera.isEstaRealizada()){
					listaCarreras.add(carrera.obtenerInfoCarrera());
				}
			}
		}
		return listaCarreras;
	}

	
	//<<<<<>>>>>>
	public Empresa(String nombreEmpresa){
		this.setNombreEmpresa(nombreEmpresa);
		this.carreras = new ArrayList<Carrera>();
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	@Override
	public String toString() {
		return "Empresa [nombreEmpresa=" + nombreEmpresa + ", carreras=" + carreras + "]";
	}
}
