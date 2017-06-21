package modulo.gestion;

import excepciones.NumeroInvalidoException;

public abstract class Producto implements Comparable<Producto> {

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

	private final static Categorias categoriaDelProductoSimple = Categorias.OTROS;

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
	 * @throws NumeroInvalidoException
	 */
	public Producto(String descripcion, Double precioDeCompra, Double precioDeVenta) throws NumeroInvalidoException {

		setCodigoDeProducto();
		setDescripcion(descripcion);
		setPrecioDeCompra(precioDeCompra);
		setPrecioDeVenta(precioDeVenta);
	}

	/**
	 * @param descripcion:
	 *            Descripcion del ProducoSimple.
	 */
	public Producto(String descripcion) {

		setCodigoDeProducto();
		setDescripcion(descripcion);
	}

	/*
	 * Devuelve un cadena de caracteres con la descripcion y el precio de venta.
	 */
	public abstract String toString();
	
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
	 * Asigna la descripcion del ProductoSimple.
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
	 *  Asigna el precio de compra del ProductoSimple.
	 */
	private void setPrecioDeCompra(Double precioDeCompra) throws NumeroInvalidoException {

		if (precioDeCompra >= 0) {

			this.precioDeCompra = precioDeCompra;
	
		} else {

			throw new NumeroInvalidoException("El precio de costo no puede ser negativo");
		}
	}

	/*
	 * Devuelve el precio de venta.
	 */
	public abstract Double getPrecioDeVenta() throws NumeroInvalidoException;

	/*
	 * Asigna el precio de venta del ProducoSimple.
	 */
	private void setPrecioDeVenta(Double precioDeVenta) throws NumeroInvalidoException {

		if (precioDeVenta > 0 && precioDeVenta > this.precioDeCompra) {

			this.precioDeVenta = precioDeVenta;
		} else {

			throw new NumeroInvalidoException("El precio de venta debe ser mayor a cero y al precio de costo");
		}
	}

	public Categorias getCategoria() {

		return Producto.categoriaDelProductoSimple;
	}

	public int compareTo(Producto producoSimpleAComparar) {

		int comparado;

		if (this.getCategoria().ordinal() == producoSimpleAComparar.getCategoria().ordinal()) {

			comparado = 0;
		} else if (this.getCategoria().ordinal() <= producoSimpleAComparar.getCategoria().ordinal()) {

			comparado = -1;
		} else {

			comparado = 1;
		}
		
		return comparado;

	}

}