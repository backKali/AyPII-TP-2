package modulo.gestion;

import excepciones.NumeroInvalido;

public abstract class ProducoSimple implements Comparable<ProducoSimple> {

	/**
	 * @codigoDeProducto: Codigo unico que identifica al ProductoSimple.
	 * @descripcion: Descripcion del ProductoSimple.
	 * @precioDeCompra: Indica el precio al que se compro el ProducoSimple.
	 * @precioDeVenta: Indica el precio al que se vendera el ProducoSimple.
	 */
	protected Integer codigoDeProducto;
	protected String descripcion;
	protected Double precioDeCompra;
	protected Double precioDeVenta;

	private final static Categorias categoriaDelComponent = Categorias.OTROS;

	protected static Integer contador = 0;

	/**
	 * @param codigoDeProducto:
	 *            el codigo que poseera.
	 * @param descripcion:
	 *            indica la descripcion.
	 * @param precioDeCompra:
	 *            indica el precio de compra, mayor a cero.
	 * @param precioDeVenta:
	 *            indica el precio de venta, mayor al precio de compra.
	 * @throws NumeroInvalido
	 */
	public ProducoSimple(String descripcion, Double precioDeCompra, Double precioDeVenta) throws NumeroInvalido {

		setCodigoDeProducto();
		setDescripcion(descripcion);
		setPrecioDeCompra(precioDeCompra);
		setPrecioDeVenta(precioDeVenta);
	}

	/**
	 * @param descripcion:
	 *            Descripcion del ProducoSimple.
	 */
	public ProducoSimple(String descripcion) {

		setCodigoDeProducto();
		setDescripcion(descripcion);
	}

	/*
	 * Devuelve un cadena de caracteres con la descripcion y el precio de venta.
	 */
	public String toString() {

		return this.descripcion + "\n" + "$ " + this.precioDeVenta + "\n";
	}

	/*
	 * Devuelve el codigo que lo identifica y es unico.
	 */
	public Integer getCodigoDeProducto() {

		return codigoDeProducto;
	}

	/*
	 * Genera el codigo que lo identificara.
	 */
	private void setCodigoDeProducto() {

		this.codigoDeProducto = contador + 1;
	}

	/*
	 * Devuelve la descripcion.
	 */
	public String getDescripcion() {

		return descripcion;
	}

	/*
	 * Asigna la descripcion del ProducoSimple.
	 */
	private void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
	}

	/*
	 * Devuelve el precio de compra.
	 */
	public Double getPrecioDeCompra() {

		return precioDeCompra;
	}

	/*
	 *  Asigna el precio de compra del ProducoSimple.
	 */
	private void setPrecioDeCompra(Double precioDeCompra) throws NumeroInvalido {

		if (precioDeCompra >= 0) {

			this.precioDeCompra = precioDeCompra;
		} else {

			throw new NumeroInvalido("El precio de costo no puede ser negativo");
		}
	}

	/*
	 * Devuelve el precio de venta.
	 */
	public Double getPrecioDeVenta() {

		return precioDeVenta;
	}

	/*
	 * Asigna el precio de venta del ProducoSimple.
	 */
	private void setPrecioDeVenta(Double precioDeVenta) throws NumeroInvalido {

		if (precioDeVenta > 0 && precioDeVenta > this.precioDeCompra) {

			this.precioDeVenta = precioDeVenta;
		} else {

			throw new NumeroInvalido("El precio de venta debe ser mayor a cero y al precio de costo");
		}
	}

	public Categorias getCategoria() {

		return ProducoSimple.categoriaDelComponent;
	}

	public int compareTo(ProducoSimple producoSimpleAComparar) {

		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this.getCategoria().ordinal() == producoSimpleAComparar.getCategoria().ordinal()) {

			return EQUAL;
		} else if (this.getCategoria().ordinal() <= producoSimpleAComparar.getCategoria().ordinal()) {

			return BEFORE;
		} else {

			return AFTER;
		}

	}

}
