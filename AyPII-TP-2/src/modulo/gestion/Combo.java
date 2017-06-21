package modulo.gestion;

import java.util.*;

import excepciones.NumeroInvalidoException;

public class Combo extends Producto implements Comparable<Producto> {

	/**
	 * @productosDelCombo: Productos que se encuentran en el Combo.
	 * @descuento: Indica el descuento que se le aplica al Combo.
	 * @queContieneElCombo: Los productos incluidos en el Combo.
	 */
	private TreeSet<Producto> productosDelCombo;
	private Double precioDeVenta;
	private Integer descuento;
	private String queContieneElCombo = "El Combo incluye:";
	private final static Categorias categoriaDelCombo = Categorias.COMBOS;

	/**
	 * @param descripcion:
	 *            Descripcion del Combo.
	 * @param descuento:
	 *            Descuento que se le va a aplicar al Combo.
	 * @param productosEnElCombo:
	 *            Los productos de Combo.
	 */
	public Combo(String descripcion, Integer descuento, TreeSet<Producto> productosEnElCombo) throws NumeroInvalidoException {

		super(descripcion);
		this.productosDelCombo = new TreeSet<Producto>();
		setDescuento(descuento);

		Iterator<Producto> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			Producto productoAIncluir = itr.next();

			productosDelCombo.add(productoAIncluir);
			queContieneElCombo += productoAIncluir.getDescripcion() + " ";
		}

	}
	
	public TreeSet<Producto> getProductosDelCombo(){
		return this.productosDelCombo;
	}

	/**
	 * @param descuento
	 * @throws NumeroInvalidoException
	 */
	private void setDescuento(Integer descuento) throws NumeroInvalidoException {

		if (descuento >= 0 && descuento < 100) {

			this.descuento = descuento;
		
		} else {

			throw new NumeroInvalidoException("El descuento debe ser mayor o igual a cero y menor a cien");
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
	public void agregarProductoAlCombo(Producto producto) {

		this.productosDelCombo.add(producto);
	}

	/**
	 * @param combo:
	 *            Combo que se va a agregar a este Combo.
	 */
	public void agregarComboAlCombo(Combo combo) {

		this.productosDelCombo.addAll(combo.productosDelCombo);
	}

	/**
	 * Le asigna el precio de compra al Combo.
	 */
	private Double getPrecioDeCompra(TreeSet<Producto> productosEnElCombo) {

		Double precio = 0.0;

		Iterator<Producto> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			precio += itr.next().precioDeCompra;
		}

		return precio;
	}

	/**
	 * Le asigna un precio de venta al Combo con un descuento.
	 * @throws NumeroInvalidoException 
	 */
	public Double getPrecioDeVenta(TreeSet<Producto> productosEnElCombo) throws NumeroInvalidoException {

		Double precio = 0.0;
		
		Iterator<Producto> itr = productosEnElCombo.iterator();
		while (itr.hasNext()) {

			precio += itr.next().precioDeVenta;
		}

		Double precioConDescuento = aplicarDescuento(precio);

		if (getPrecioDeCompra(productosEnElCombo) >= precioConDescuento){
		
			throw new NumeroInvalidoException("El precio de Venta debe ser mayor al precio de Compra");
		
		} else {
			
			this.precioDeVenta = precioConDescuento;
		
		}
		
		return this.precioDeVenta;

	}

	/**
	 * Aplica el descuento al Combo.
	 */
	private Double aplicarDescuento(Double precio) {

		Double precioConDescuento = (precio - ( precio * (descuento.doubleValue() / 100)));
		
		return precioConDescuento;
	}

	public Categorias getCategoria() {

		return Combo.categoriaDelCombo;
	}

	/**
	 * @return: Devuelve un String con la descripcion, el precio de venta y lo
	 *          incluido en el Combo.
	 */
	public String toString() {

		try {
			this.getPrecioDeVenta(getProductosDelCombo());
		} catch (NumeroInvalidoException mensaje) {
			System.out.println("El numero ingresado es invalido");
		}
		
		setQueContieneElCombo();
		
		return this.descripcion + "\n$ " + this.precioDeVenta + "\n" + this.queContieneElCombo + "\n";
	}
	
	private void setQueContieneElCombo(){
		
		String productos = "";
		
		Iterator<Producto> iterador = productosDelCombo.iterator();
		while (iterador.hasNext()) {

			productos += " " + iterador.next().getDescripcion();
		}

		queContieneElCombo = queContieneElCombo + productos;
	}

	public int compareTo(Producto ProducoSimpleAComparar) {

		int comparado;

		if (this.getCategoria().ordinal() == ProducoSimpleAComparar.getCategoria().ordinal()) {

			comparado = 0;
		} else if (this.getCategoria().ordinal() <= ProducoSimpleAComparar.getCategoria().ordinal()) {

			comparado = -1;
		} else {

			comparado = 1;
		}
		
		return comparado;
	}

}