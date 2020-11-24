package ort.thp.tp4.tests;

import ort.thp.tp4.clases.AgendaMedica;

public class TestEj4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AgendaMedica agenda1=new AgendaMedica(3);
		System.out.println(agenda1.registrarTurno("11111111", "Lautaro", "Bernati", "1122225555"));
		System.out.println(agenda1.registrarTurno("11111111", "Lautaro", "Bernati", "1122225555"));
		System.out.println(agenda1.registrarTurno("22222222", "Pepito", "Pepon", "1133335555"));
		//agenda1.listarTurnos();
		System.out.println("Pacientes Ausentes:"+agenda1.obtenerAusentes());
		System.out.println(agenda1.darPresente("11111111"));
		System.out.println("Pacientes Ausentes:"+agenda1.obtenerAusentes());
		agenda1.listarTurnos();
		System.out.println(agenda1.anularTurno("11111111"));
		agenda1.listarTurnos();
		//FUNCTIONAL.
	}
}
