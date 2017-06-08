package modulo.precios;

import java.util.*;

import excepciones.NumeroInvalido;
import modulo.gestion.Categorias;
import modulo.gestion.Combo;
import modulo.gestion.ProducoSimple;
import modulo.gestion.Producto;

public class ModuloDeGestionDePrecios {

	/**
	 * @instance: Restringe la creacion de mas de un ModuloDeGestionDePrecios.
	 * @listadoDeProductos: Listado con todos los productos y combos.
	 */
	private static ModuloDeGestionDePrecios instance;
	private Set<ProducoSimple> listadoDeProductos;

	/**
	 * Constructor privado al cual solo se puede acceder desde getInstance().
	 */
	private ModuloDeGestionDePrecios() {

		listadoDeProductos = new TreeSet<ProducoSimple>();

	}

	/**
	 * Crea una instancia del ModuloDeCaja sólo si todavía no existe alguna.
	 * 
	 * @retutn: Devuelve una instancia del ModuloDeGestionDePrecios.
	 */
	public static ModuloDeGestionDePrecios getInstance() {

		if (instance == null) {

			instance = new ModuloDeGestionDePrecios();
		}

		return instance;
	}

	/**
	 * @param descripcion:
	 *            La descripcion del producto que se busca.
	 * @return: Devuelve la informacion del producto buscado.
	 */
	public String consultarDatosDeUnProducto(String descripcion) {

		Iterator<ProducoSimple> itr = listadoDeProductos.iterator();
		while (itr.hasNext()) {

			ProducoSimple producto = itr.next();
			if (descripcion.equals(producto.getDescripcion())) {

				return producto.toString();
			}
		}

		listadoDeProductos.contains(descripcion);
		return null;
	}

	/**
	 * @param codigo:
	 *            Codigo del producto que se busca.
	 * @return: devuelve la informacion del producto que se busca.
	 */
	public String consultarDatosDeUnProducto(Integer codigo) {

		Iterator<ProducoSimple> itr = listadoDeProductos.iterator();
		while (itr.hasNext()) {

			ProducoSimple producto = itr.next();
			if (codigo.equals(producto.getCodigoDeProducto())) {

				return producto.toString();
			}
		}
		return null;
	}

	/**
	 * @param descripcion:
	 *            Descripcion del producto.
	 * @param precioDeCompra:
	 *            Precio al que se compro el producto.
	 * @param precioDeVenta:
	 *            Precio de al que se vendera.
	 * @param categoria:
	 *            Categoria a la que pertenece.
	 */
	public void darDeAltaUnNuevoProcuto(String descripcion, Double precioDeCompra, Double precioDeVenta,
			Categorias categoria) throws NumeroInvalido {

		// Hay que ver si esto funciona bien.

		listadoDeProductos.add(new Producto(descripcion, precioDeCompra, precioDeVenta, categoria));
	}

	/**
	 * @param codigo:
	 *            Codigo del producto que se desea dar de baja.
	 */
	public void darDeBajaUnProducto(Integer codigo) {

		Iterator<ProducoSimple> itr = listadoDeProductos.iterator();
		while (itr.hasNext()) {

			ProducoSimple producto = itr.next();
			if (codigo.equals(producto.getCodigoDeProducto())) {

				listadoDeProductos.remove(producto);
			}
		}
	}

	public void modificarUnProducto() {

	}

	/**
	 * @param descripcion:
	 *            Descripcion del combo.
	 * @param descuento:
	 *            Descuento que poseera el combo.
	 * @param productosDelCombo:
	 *            Productos incluidos en el combo.
	 */
	public void generarUnCombo(String descripcion, Integer descuento, TreeSet<ProducoSimple> productosDelCombo)
			throws NumeroInvalido {

		// Hay que ver si esto funciona bien.
		Combo combo = new Combo(descripcion, descuento, productosDelCombo);
		listadoDeProductos.add(combo);
	}

	/**
	 * Imprime la carta con todos los productos y combos.
	 */
	public void imprimirCarta() {

		Iterator<ProducoSimple> itr = listadoDeProductos.iterator();
		while (itr.hasNext()) {

			System.out.println(itr.next().toString());
		}
	}

	/**
	 * Agrega un Combo.
	 * @param combo: Combo que se va agregar.
	 */
	public void agregarCombo(Combo combo) {

		listadoDeProductos.add(combo);
	}

}
