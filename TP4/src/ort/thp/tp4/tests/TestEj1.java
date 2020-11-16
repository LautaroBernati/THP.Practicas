package ort.thp.tp4.tests;

import ort.thp.tp4.clases.Agenda;
import ort.thp.tp4.clases.Persona;

public class TestEj1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Agenda contactos1=new Agenda();
        Persona persona1=new Persona("Lautaro", "Bernati", "Carolina dsasda", "12222555");

        contactos1.agregarPersona("Lautaro", "Bernati", "asdasd", "12555777");
        contactos1.agregarPersona("jaimito", "Bernati", "asdasd", "77777777");
        contactos1.agregarPersona("pepito", "Bernati", "asdasd", "5555555");

        contactos1.listarPersonas();

        contactos1.agregarPersona("asdas", "asdad", "asdasd", "12555777");
        contactos1.listarPersonas();
    }

}
