package modulo.gestion;

import java.util.*;

import excepciones.NumeroInvalido;

public class Combo extends ProducoSimple implements Comparable<ProducoSimple> {

	/**
	 * @productosDelCombo: Productos que se encuentran en el Combo.
	 * @descuento: Indica el descuento que se le aplica al Combo.
	 * @queContieneElCombo: Los productos incluidos en el Combo.
	 */
	private Set<ProducoSimple> productosDelCombo;
	private Integer descuento;
	private String queContieneElCombo = "El Combo incluye: ";
	private final static Categorias categoriaDelCombo = Categorias.COMBOS;

	/**
	 * @param descripcion:
	 *            Descripcion del Combo.
	 * @param descuento:
	 *            Descuento que se le va a aplicar al Combo.
	 * @param productosEnElCombo:
	 *            Los productos de Combo.
	 */
	public Combo(String descripcion, Integer descuento, TreeSet<ProducoSimple> productosEnElCombo) throws NumeroInvalido {

		super(descripcion);
		this.productosDelCombo = new TreeSet<ProducoSimple>();
		setDescuento(descuento);
		setPrecioDeCompra(productosEnElCombo);
		setPrecioDeVenta(productosEnElCombo);

		Iterator<ProducoSimple> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			ProducoSimple productoAIncluir = itr.next();

			productosDelCombo.add(productoAIncluir);
			queContieneElCombo += productoAIncluir.getDescripcion() + " ";
		}

	}

	/**
	 * @param descuento
	 * @throws NumeroInvalido
	 */
	private void setDescuento(Integer descuento) throws NumeroInvalido {

		if (descuento >= 0 && descuento < 100) {

			this.descuento = descuento;
		} else {

			throw new NumeroInvalido("El descuento debe ser mayor o igual a cero y menor a cien");
		}
	}

	/**
	 * @return: Descuento que posee el Combo.
	 */
	public Integer getDescuento() {

		return this.descuento;
	}

	/**
	 * @param producto:
	 *            producto que se va a agregarAlCombo.
	 */
	public void agregarProductoAlCombo(ProducoSimple producto) {

		this.precioDeCompra += producto.getPrecioDeCompra();
		this.precioDeVenta += producto.getPrecioDeVenta();
		this.productosDelCombo.add(producto);
	}

	/**
	 * @param combo:
	 *            Combo que se va a agregar a este Combo.
	 */
	public void agregarComboAlCombo(Combo combo) {

		this.precioDeCompra += combo.getPrecioDeCompra();
		this.precioDeVenta += combo.getPrecioDeVenta();
		this.productosDelCombo.addAll(productosDelCombo);
	}

	/**
	 * Le asigna el precio de compra al Combo.
	 */
	private void setPrecioDeCompra(TreeSet<ProducoSimple> productosEnElCombo) {

		Double precio = 0.0;

		Iterator<ProducoSimple> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			precio += itr.next().precioDeCompra;
		}

		this.precioDeCompra = precio;
	}

	/**
	 * Le asigna un precio de venta al Combo con un descuento.
	 */
	private void setPrecioDeVenta(TreeSet<ProducoSimple> productosEnElCombo) {

		Double precio = 0.0;

		Iterator<ProducoSimple> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			precio += itr.next().precioDeVenta;
		}

		precio = aplicarDescuento(precio);

		this.precioDeVenta = precio;

	}

	/**
	 * Aplica el descuento al Combo.
	 */
	private Double aplicarDescuento(Double precio) {

		Double p = precio - (precio * descuento / 100);
		return p;
	}

	public Categorias getCategoria() {

		return Combo.categoriaDelCombo;
	}

	/**
	 * @return: Devuelve un String con la descripcion, el precio de venta y lo
	 *          incluido en el Combo.
	 */
	public String toString() {

		return this.descripcion + "\n" + "$ " + this.precioDeVenta + "\n" + this.queContieneElCombo + "\n";
	}

	public int compareTo(ProducoSimple ProducoSimpleAComparar) {

		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this.getCategoria().ordinal() == ProducoSimpleAComparar.getCategoria().ordinal()) {

			return EQUAL;
		} else if (this.getCategoria().ordinal() <= ProducoSimpleAComparar.getCategoria().ordinal()) {

			return BEFORE;
		} else {

			return AFTER;
		}
	}

}
