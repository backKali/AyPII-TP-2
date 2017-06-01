package modulo.precios;

import java.util.*;

import modulo.gestion.Component;

public class ModuloDeGestionDePrecios {

	private static ModuloDeGestionDePrecios instance;
	
	// no estoy seguro de que seria mejor si el Hash o el Tree 
	// porque creo que no necesitamos tenerlos almacenados en orden.
	private Set<Component> listadoDePrecios;
	
	
	private ModuloDeGestionDePrecios() {
		
		listadoDePrecios = new HashSet<Component>();
	}
	
	public static ModuloDeGestionDePrecios getInstance() {

		if (instance == null) {

			instance = new ModuloDeGestionDePrecios();
		}

		return instance;
	}
	
	public Component consultarDatosDeUnProducto(String descripcion) {
		
		return null;
	}
	
	public Component consultarDatosDeUnProducto(Integer a) {
		
		return null;
	}
	
	public void darDeAltaUnNuevoProcuto() {
		
	}
	
	public void darDeBajaUnProducto() {
		
	}
	
	public void modificarUnProducto() {
		
	}
	
	public void generarUnCombo() {
		
	}
	
	public void imprimirCarta() {
		
	}
	
	
}
