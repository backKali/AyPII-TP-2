package modulo.gestion;

import java.util.*;

import excepciones.NumeroInvalido;

public class Combo extends Component implements Comparable<Component> {

	private Set<Component> productosDelCombo;
	private Integer descuento;
	private String queContieneElCombo = "El Combo incluye: ";
	private final static Categorias categoriaDelCombo = Categorias.COMBOS;

	public Combo(String descripcion, Integer descuento, TreeSet<Component> productosEnElCombo) throws NumeroInvalido {

		super(descripcion);
		this.productosDelCombo = new TreeSet<Component>();
		setDescuento(descuento);
		setPrecioDeCompra(productosEnElCombo);
		setPrecioDeVenta(productosEnElCombo);

		Iterator<Component> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			Component c = itr.next();

			productosDelCombo.add(c);
			queContieneElCombo += c.getDescripcion() + " ";
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
	 * @return:
	 */
	public Integer getDescuento() {

		return this.descuento;
	}

	/**
	 * @param producto:
	 *            producto que se va a agregarAlCombo.
	 */
	public void agregarProductoAlCombo(Component producto) {

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
	private void setPrecioDeCompra(TreeSet<Component> productosEnElCombo) {

		Double precio = 0.0;

		Iterator<Component> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			precio += itr.next().precioDeCompra;
		}

		this.precioDeCompra = precio;
	}

	/**
	 * Le asigna un precio de venta al Combo con un descuento.
	 */
	private void setPrecioDeVenta(TreeSet<Component> productosEnElCombo) {

		Double precio = 0.0;

		Iterator<Component> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			precio += itr.next().precioDeVenta;
		}

		precio = aplicarDescuento(precio);

		this.precioDeVenta = precio;

	}

	private Double aplicarDescuento(Double precio) {

		Double p = precio - (precio * descuento / 100);
		return p;
	}

	public Categorias getCategoria() {

		return Combo.categoriaDelCombo;
	}

	public String toString() {

		return this.descripcion + "\n" + "$ " + this.precioDeVenta + "\n" + this.queContieneElCombo + "\n";
	}

	public int compareTo(Component c) {

		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this.getCategoria().ordinal() == c.getCategoria().ordinal()) {

			return EQUAL;
		} else if (this.getCategoria().ordinal() <= c.getCategoria().ordinal()) {

			return BEFORE;
		} else {

			return AFTER;
		}
	}

}
