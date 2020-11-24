package ort.thp.tp4.clases;

import java.util.ArrayList;

public class ReproductorDeMusica {
	
	private ArrayList<Usuario> usuarios;
	private ArrayList<Cancion> canciones;
	
	private int TOPE_GRATUITO=50;
	
	public void listarCancionesPorUsuario(String email){
		Usuario usuario=null;
		usuario=buscarUsuario(email);
		if(usuario!=null){
			usuario.mostrarCancionesEscuchadas();
			System.out.println("Operacion exitosa.");
		}
		else{
			System.out.println("Usuario inexistente.");
		}
	}
	
	public void listarUsuarios(){
		System.out.println(this.usuarios);
		
	}
	
	public ResultadoDeReproduccion escucharCancion(String email, String nombreCancion, String autor){
		ResultadoDeReproduccion resultado=ResultadoDeReproduccion.CANCION_INEXISTENTE;
		Usuario usuario=null;
		Cancion cancion=null;
		usuario=buscarUsuario(email);
		cancion=buscarCancion(nombreCancion, autor);
		
		if(usuario!=null && cancion!=null){
			switch(usuario.getCategoria()){
			case PREMIUM:
				cancion.setCantidadEscuchada(cancion.getCantidadEscuchada()+1);
				usuario.agregarCancionEscuchada(cancion);
				cancion.recalcularCategoria();
				resultado=ResultadoDeReproduccion.CANCION_ESCUCHADA;
				break;
			case REGISTRADO:
				if(cancion.getCategoria()==Categoria.PREMIUM){
					resultado=ResultadoDeReproduccion.CANCION_NO_DISPONIBLE;
				}
				else{
					cancion.setCantidadEscuchada(cancion.getCantidadEscuchada()+1);
					usuario.agregarCancionEscuchada(cancion);
					cancion.recalcularCategoria();
					resultado=ResultadoDeReproduccion.CANCION_ESCUCHADA;
				}
				break;
			case GRATUITO:
				if(cancion.getCategoria()==Categoria.PREMIUM){
					resultado=ResultadoDeReproduccion.CANCION_NO_DISPONIBLE;
				}
				else if(usuario.cantCancionesEscuchadas()>=TOPE_GRATUITO){//limitador
					resultado=ResultadoDeReproduccion.LIMITE_ALCANZADO;
				}
				else{
					cancion.setCantidadEscuchada(cancion.getCantidadEscuchada()+1);
					usuario.agregarCancionEscuchada(cancion);
					cancion.recalcularCategoria();
					resultado=ResultadoDeReproduccion.CANCION_ESCUCHADA;
				}
				break;
			}//< fin del switch
		}
		else if(usuario==null){
			resultado=ResultadoDeReproduccion.USUARIO_INEXISTENTE;
		}
		return resultado;
	}
	
	
	public boolean altaUsuario(String email, String apellido, int edad, Categoria categoria){
		boolean ok=false;
		Usuario UsuarioAAgregar=null;
		UsuarioAAgregar=buscarUsuario(email);
		if(UsuarioAAgregar==null){//si NO estaba en la lista de usuarios...
			UsuarioAAgregar=new Usuario(email, apellido, edad, categoria);
			this.usuarios.add(UsuarioAAgregar);
			ok=true;
		}
		return ok;
	}
	
	public boolean altaCancion(String nombre, String autor, String genero, int diasDesdePublicacion){
		boolean ok=false;
		Cancion cancionAAgregar=null;
		cancionAAgregar=buscarCancion(nombre, autor);
		if(cancionAAgregar==null){//si no esta en la lista...
			cancionAAgregar=new Cancion(nombre, autor, genero, diasDesdePublicacion);
			this.canciones.add(cancionAAgregar);
			ok=true;
		}
		return ok;
	}
	
	private Usuario buscarUsuario(String email){
		Usuario usuarioEncontrado=null;
		int i=0;
		while(i<this.usuarios.size() && usuarioEncontrado==null){
			if(this.usuarios.get(i).emailUsuario()==email){
				usuarioEncontrado=this.usuarios.get(i);
			}
			i++;
		}
		return usuarioEncontrado;
	}
	
	private Cancion buscarCancion(String nombre, String autor){
		Cancion cancionEncontrada=null;
		int i=0;
		
		while(i<this.canciones.size() && cancionEncontrada==null){
			if(this.canciones.get(i).nombreCancion()==nombre && this.canciones.get(i).nombreAutor()==autor){
				cancionEncontrada=this.canciones.get(i);
			}
			i++;
		}
		return cancionEncontrada;
	}
	
	//<<<<<<<<>>>>>>>>
	
	public ReproductorDeMusica(){
		this.usuarios = new ArrayList<Usuario>();
		this.canciones = new ArrayList<Cancion>();
	}
	public enum ResultadoDeReproduccion{
		CANCION_ESCUCHADA, USUARIO_INEXISTENTE, CANCION_INEXISTENTE, LIMITE_ALCANZADO, CANCION_NO_DISPONIBLE;
	}
	@Override
	public String toString() {
		return "ReproductorDeMusica [usuarios=" + usuarios + ", canciones=" + canciones + "]";
	}
}
