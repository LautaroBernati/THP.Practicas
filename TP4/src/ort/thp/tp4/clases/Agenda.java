package ort.thp.tp4.clases;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Persona> contactos;

    public Agenda(){
        contactos = new ArrayList<Persona>(); 
    }

    private Persona buscarPersona(String dni){
        Persona personaEncontrada=null;
        int i = 0;
        while (i < this.contactos.size() && personaEncontrada == null){
            if (this.contactos.get(i).getDni().equals(dni)){
                personaEncontrada = this.contactos.get(i);
            }
            i++;
        }
        return personaEncontrada;
    }

    public boolean agregarPersona(String nombre, String apellido, String direccion, String dni){
        boolean resultado=false;
        Persona persona;
        persona=buscarPersona(dni);
        if(persona==null){ //si no encontro el dni...
            persona = new Persona(nombre, apellido, direccion, dni);
            contactos.add(persona);
            resultado=true;
        }
        return resultado;
    }

    public Persona removerPersona(String dni){
        Persona personaRemovida=null;
        int i = 0;
        while (i < this.contactos.size() && personaRemovida == null){
            if (this.contactos.get(i).getDni().equals(dni)){
                personaRemovida = this.contactos.remove(i);
            }
            i++;
        }
        return personaRemovida;
    }

    public boolean modificarDomicilio(String dni, String direccion){
        boolean resultado=false;
        Persona persona=null;

        persona=buscarPersona(dni); //busca por dni la persona, si la encuentra la asigna
        if(persona!=null){ //si la persona existe...
            persona.setDireccion(direccion); // modifica su direccion
            resultado=true;
        }
        return resultado;
    }

    public void listarPersonas(){
        System.out.println(this.contactos);
    }

    @Override
    public String toString() {
        return "Agenda [contactos=" + contactos + "]";
    }
}
