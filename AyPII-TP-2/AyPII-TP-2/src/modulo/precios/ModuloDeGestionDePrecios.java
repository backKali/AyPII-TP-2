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

	/**
	 * @param descripcion: La descripcion del producto que se busca.
	 * @return: Devuelve la informacion del producto buscado.
	 */
	public String consultarDatosDeUnProducto(String descripcion) {

		Iterator<Component> itr = listadoDePrecios.iterator();
		while (itr.hasNext()) {

			Component c = itr.next();
			if (descripcion.equals(c.getDescripcion())) {

				return c.toString();
			}
		}
		return null;
	}

	/**
	 * @param codigo: Codigo del producto que se busca.
	 * @return: devuelve la informacion del producto que se busca.
	 */
	public String consultarDatosDeUnProducto(Integer codigo) {

		Iterator<Component> itr = listadoDePrecios.iterator();
		while (itr.hasNext()) {

			Component c = itr.next();
			if (codigo.equals(c.getCodigoDeProducto())) {

				return c.toString();
			}
		}
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
