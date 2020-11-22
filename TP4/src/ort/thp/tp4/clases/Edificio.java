package ort.thp.tp4.clases;

import java.util.ArrayList;

public class Edificio {
	
	private String direccion;
	private int cantidadTotalDepartamentos;
	private ArrayList<Departamento>departamentos;
	private ArrayList<Departamento>deudores;
	
	
	public void listarUnidades(){
		System.out.println(departamentos);
	}
	
	public void listarMorosos(){
		if(this.deudores.isEmpty())
			System.out.println("No hay deudores.");
		else{
			System.out.println(deudores);
		}
	}
	
	public boolean cancelarDeuda(int unidad, double importe){
		boolean ok=false;
		Departamento depto=null;
		
		if(importe>0){
			depto=buscarDepartamento(unidad);
			if(depto!=null){//si existe
				depto.setDeuda(depto.getDeuda()-importe);
				if(depto.getDeuda()<=0){
					removerDeMorosos(depto, unidad);
				}
			}
		}
		else{
			System.out.println("Debe ingresar un importe mayor a 0.");
		}
		return ok;
	}
	
	private void removerDeMorosos(Departamento departamento, int unidad){
		int i=0;
		while(i<this.deudores.size()){
				if(this.deudores.get(i).getNumeroUnidad()==unidad){
					this.deudores.remove(i);
					System.out.println("Removido (debug)");
				}
			i++;
		}
	}
	
	public boolean agregarDeuda(int unidad, double importe){
		boolean ok=false;
		Departamento depto=null;
		//Departamento deptoMoroso=null;
		if(importe>0){
			depto=buscarDepartamento(unidad);
			if(depto!=null){//si encontro la unidad(depto)
				depto.setDeuda(depto.getDeuda()+importe);
				//deptoMoroso=buscarDepartamentoMoroso(unidad);
				if(buscarDepartamentoMoroso(unidad)==null){
					this.deudores.add(depto);
				}
			}
			else{
				System.out.println("No se encuentra esa unidad.");
			}
		}
		else{
			System.out.println("Debe ingresar un importe mayor a 0");
		}
		return ok;
	}
	
	public boolean habitarUnidad(int unidad, Propietario propietario){
		boolean ok=false;
		int i=0;
		Departamento depto=null;
		
		depto=buscarDepartamento(unidad);
		if(depto!=null){
			if(depto.estaHabitado()==false){
				depto.setPropietario(propietario);
				ok=true;
			}
		}
			
		
		
		
		/*while(i<this.departamentos.size() && ok==false){
			if(this.departamentos.get(i).estaHabitado()==false ){//revisa si esta ocupado
				this.departamentos.get(i).setPropietario(propietario);
				ok=true;
			}
			i++;
		}*/
		
		return ok;
	}
	
	private Departamento buscarDepartamentoMoroso(int unidad){
		Departamento departamento1=null;
		int i=0;
		
		while(i<this.deudores.size() && departamento1==null){
			if(this.deudores.get(i).getNumeroUnidad()==unidad){
				departamento1=this.deudores.get(i);
			}
		}
		return departamento1;
	}
	
	private Departamento buscarDepartamento(int unidad){
		Departamento departamento1=null;
		int i=0;
		
		while(i<this.departamentos.size() && departamento1==null){
			if(this.departamentos.get(i).getNumeroUnidad()==unidad){
				departamento1=this.departamentos.get(i);
			}
		}
		return departamento1;
	}
	
	private void inicializarDepartamentos(){ //leer constructor
		int numUnidad=1;
		Departamento departamentoNuevo=null;
		while(this.departamentos.size()<this.getCantidadTotalDepartamentos()){
			departamentoNuevo=new Departamento(numUnidad);
			this.departamentos.add(departamentoNuevo);
			numUnidad++;
		}
	}
	
	//<<<<<<>>>>>>
	
	public Edificio(String direccion, int cantidadTotalDepartamentos) {	
		this.setDireccion(direccion);
		this.setCantidadTotalDepartamentos(cantidadTotalDepartamentos);
		this.departamentos = new ArrayList<Departamento>();
		inicializarDepartamentos(); //debe agregar vacios y sin deuda todos los departamentos del edificio
		this.deudores = new ArrayList<Departamento>();
	}
	@Override
	public String toString() {
		return "Edificio [direccion=" + direccion + ", cantidadTotalDepartamentos=" + cantidadTotalDepartamentos
				+ ", departamentos=" + departamentos + ", deudores=" + deudores + "]";
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCantidadTotalDepartamentos() {
		return cantidadTotalDepartamentos;
	}
	public void setCantidadTotalDepartamentos(int cantidadTotalDepartamentos) {
		this.cantidadTotalDepartamentos = cantidadTotalDepartamentos;
	}
	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(ArrayList<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	public ArrayList<Departamento> getDeudores() {
		return deudores;
	}
	public void setDeudores(ArrayList<Departamento> deudores) {
		this.deudores = deudores;
	}
}
