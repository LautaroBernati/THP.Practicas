package ort.thp.tp4.tests;

import ort.thp.tp4.clases.Dificultad;
import ort.thp.tp4.clases.Empresa;

public class TestEj5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empresa empresa1=new Empresa("Empresita");
		
		System.out.println(empresa1.prepararCarrera("22/10", "13hs", Dificultad.PRINCIPIANTE, 3));
		System.out.println(empresa1.prepararCarrera("22/10", "13hs", Dificultad.PRINCIPIANTE, 3));//debe dar false
		System.out.println(empresa1);
		System.out.println(empresa1.prepararPiloto("22/10", "Lautaro", "11222333"));
		System.out.println(empresa1.prepararPiloto("22/10", "Lautaro", "11222333"));//debe retornar false
		System.out.println(empresa1.prepararPiloto("22/10", "Pepe", "22333444"));
		System.out.println(empresa1.correrCarrera("22/10"));
		System.out.println(empresa1.informeResumidoPorCarrera());
	}

}
