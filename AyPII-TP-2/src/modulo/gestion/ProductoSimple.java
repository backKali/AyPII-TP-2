package modulo.gestion;

import excepciones.NumeroInvalidoException;

public class ProductoSimple extends Producto implements Comparable<Producto> {

	/**
	 * @categoria: Indica la categoria a la que pertence el Producto.
	 */
	private Categorias categoria;

	/**
	 * @param descripcion: Descripcion del Producto.
	 * @param precioDeCompra: Precio al que se compro el Producto.
	 * @param precioDeVenta: Precio al que se vendera el Producto.
	 * @param categoria: Categoria a la que pertenece el Producto.
	 */
	public ProductoSimple(String descripcion, Double precioDeCompra, Double precioDeVenta, Categorias categoria)
			throws NumeroInvalidoException {

		super(descripcion, precioDeCompra, precioDeVenta);
		this.categoria = categoria;
	}

	/**
	 * @return: Devuelve la categoria a la que pertenece el producto.
	 */
	public Categorias getCategoria() {

		return this.categoria;
	}

	
	public int compareTo(Producto c) {
		
		int comparado;
		
		if (this.getCategoria().ordinal() == c.getCategoria().ordinal()) {

			comparado = 0;
		} else if (this.getCategoria().ordinal() <= c.getCategoria().ordinal()) {

			comparado = -1;
		} else {

			comparado = 1;
		}
		
		return comparado;
			
	}
	
	public Double getPrecioDeVenta(){
		return this.precioDeVenta;
	}
	
}
