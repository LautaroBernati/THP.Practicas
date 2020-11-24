package ort.thp.tp4.clases;

import java.util.ArrayList;

public class AgendaMedica {
	
	ArrayList<Turno>turnos;
	private int cantidadTurnosMax;
	
	public ArrayList<Paciente> obtenerAusentes(){
		ArrayList<Paciente> ausentes=new ArrayList<Paciente>();
		Paciente paciente=null;
		int i=0;
		while(i<this.turnos.size()){
			if(this.turnos.get(i).estaPresente()==false){
				paciente=this.turnos.get(i).getPaciente();
				ausentes.add(paciente);
				paciente=null;//resetea
			}
			i++;
		}
		return ausentes;
	}
	
	public boolean anularTurno(String dni){
		boolean ok=false;
		int i=0;
		while(i<this.turnos.size() && ok==false){
			if(this.turnos.get(i).mostrarPaciente().mostrarDniPaciente()==dni){
				this.turnos.remove(i);
				ok=true;
			}
			i++;
		}
		return ok;
	}
	
	public boolean darPresente(String dni){
		boolean ok=false;
		Turno turno=null;
		turno=buscarTurno(dni);
		if(turno!=null){
			turno.setPresencia(true);
			ok=true;
		}
		return ok;
	}
	
	public void listarTurnos(){
		System.out.println(this.turnos);
	}
	
	public ResultadoDeRegistro registrarTurno(String dni, String nombre, String apellido, String telefono){
		ResultadoDeRegistro resultado=ResultadoDeRegistro.MEDICO_COMPLETO;
		Turno turno=null;
		if(this.turnos.size()+1<=this.cantidadTurnosMax){
			turno=buscarTurno(dni);
			if(turno==null){//si no encontro el dni...
				turno=new Turno(dni, nombre, apellido, telefono);
				this.turnos.add(turno);
				resultado=ResultadoDeRegistro.TURNO_CONFIRMADO;
			}
			else{
				resultado=ResultadoDeRegistro.DNI_PREEXISTENTE;
			}
		}
		return resultado;
	}
	
	private Turno buscarTurno(String dni){
		Turno turno=null;
		int i=0;
		while(i<this.turnos.size() && turno==null){	
			if(this.turnos.get(i).mostrarPaciente().mostrarDniPaciente()==dni){
				turno=this.turnos.get(i);
			}
			i++;
		}
		return turno;
	}
	
	//<<<<<<<<<<>>>>>>>>>>
	public AgendaMedica(int cantidadTurnos){
		this.turnos=new ArrayList<Turno>();
		setcantidadTurnosMax(cantidadTurnos);//polemico
	}
	public int getcantidadTurnosMax() {
		return cantidadTurnosMax;
	}
	public void setcantidadTurnosMax(int cantidadTurnosMax) {
		this.cantidadTurnosMax = cantidadTurnosMax;
	}
	@Override
	public String toString() {
		return "AgendaEj4 [turnos=" + turnos + ", cantidadTurnosMax=" + cantidadTurnosMax + "]";
	}

	public enum ResultadoDeRegistro {
		TURNO_CONFIRMADO, MEDICO_COMPLETO, DNI_PREEXISTENTE;
	}
}
