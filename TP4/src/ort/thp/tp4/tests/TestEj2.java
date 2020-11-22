package ort.thp.tp4.tests;

import ort.thp.tp4.clases.Edificio;
import ort.thp.tp4.clases.Propietario;

public class TestEj2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Edificio edificio1=new Edificio("Calle 111", 5);
		Propietario Lautaro=new Propietario("1111", "Lautaro");
		Propietario Juancito=new Propietario("2222", "Juancito");
		System.out.println(edificio1);
		
		System.out.println(edificio1.habitarUnidad(1, Lautaro));
		System.out.println(edificio1.habitarUnidad(1, Juancito));
		System.out.println(edificio1);
		edificio1.agregarDeuda(1, 1000);
		System.out.println(">"+edificio1);
		
		edificio1.listarMorosos();
		
		edificio1.cancelarDeuda(1, 500);
		edificio1.listarMorosos();
		edificio1.cancelarDeuda(1, 500);
		edificio1.listarMorosos();
		
	}

}
