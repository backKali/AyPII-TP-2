package modulo.gestion;

import excepciones.NumeroInvalido;

public abstract class Component {

	protected Integer codigoDeProducto;
	protected String descripcion;
	protected Double precioDeCosto;
	protected Double precioDeVenta;
	
	protected static Integer contador = 0;

	/**
	 * @param codigoDeProducto:
	 *            el codigo que poseera.
	 * @param descripcion:
	 *            indica la descripcion.
	 * @param precioDeCosto:
	 *            indica el precio de compra, debe ser mayor o igual a cero.
	 * @param precioDeVenta:
	 *            indica el precio de venta, debe ser mayor al precio de costo.
	 */
	public Component(String descripcion, Double precioDeCosto, Double precioDeVenta) throws NumeroInvalido{

		setCodigoDeProducto();
		setDescripcion(descripcion);
		setPrecioDeCosto(precioDeCosto);
		setPrecioDeVenta(precioDeVenta);
	}
	
	public Component(String descripcion) {

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
	 * 
	 */
	private void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
	}

	/*
	 * Devuelve el precio de compra.
	 */
	public Double getPrecioDeCompra() {

		return precioDeCosto;
	}

	/*
	 *  
	 */
	private void setPrecioDeCosto(Double precioDeCosto) throws NumeroInvalido {

		if (precioDeCosto >= 0){
			this.precioDeCosto = precioDeCosto;			
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
	 * 
	 */
	private void setPrecioDeVenta(Double precioDeVenta) throws NumeroInvalido {

		if (precioDeVenta > 0 && precioDeVenta > this.precioDeCosto){
			this.precioDeVenta = precioDeVenta;
		} else {
			throw new NumeroInvalido("El precio de venta debe ser mayor a cero y al precio de costo");
		}
		
	}

}
