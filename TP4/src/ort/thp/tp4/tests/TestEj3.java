package ort.thp.tp4.tests;

import ort.thp.tp4.clases.Categoria;
import ort.thp.tp4.clases.ReproductorDeMusica;

public class TestEj3 {

	public static void main(String[] args) {
		
		ReproductorDeMusica reproductor1=new ReproductorDeMusica();
		
		System.out.println(reproductor1.altaUsuario("lautaro@mail.com", "bernati", 23, Categoria.PREMIUM));
		System.out.println(reproductor1.altaUsuario("pepito@mail.com", "pepe", 23, Categoria.GRATUITO));
		reproductor1.listarCancionesPorUsuario("lautaro@mail.com");
		
		System.out.println(reproductor1.altaCancion("Suavemente", "Elvis Crespo", "Salsa", 2));
		System.out.println(reproductor1.altaCancion("Suavemente", "Elvis Crespo", "Salsa", 2));
		System.out.println(reproductor1.altaCancion("Procura", "ChiChi Peralta", "Salsa", 8));
		
		System.out.println(reproductor1.escucharCancion("lautaro@mail.com", "Suavemente", "Elvis Crespo"));
		System.out.println(reproductor1.escucharCancion("lautaro@mail.com", "Suavemente", "Elvis Crespo"));
		System.out.println(reproductor1.escucharCancion("lautaro@mail.com", "Procura", "ChiChi Peralta"));
		reproductor1.listarUsuarios();
		System.out.println(reproductor1.escucharCancion("pepito@mail.com", "Procura", "ChiChi Peralta"));
		System.out.println(reproductor1.escucharCancion("pepito@mail.com", "Procura", "ChiChi Peralta"));
		//FINITO.
	}

}
