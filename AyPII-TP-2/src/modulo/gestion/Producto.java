package modulo.gestion;

import excepciones.NumeroInvalido;

public class Producto extends ProducoSimple implements Comparable<ProducoSimple> {

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
	public Producto(String descripcion, Double precioDeCompra, Double precioDeVenta, Categorias categoria)
			throws NumeroInvalido {

		super(descripcion, precioDeCompra, precioDeVenta);
		this.categoria = categoria;
	}

	/**
	 * @return: Devuelve la categoria a la que pertenece el producto.
	 */
	public Categorias getCategoria() {

		return this.categoria;
	}

	
	public int compareTo(ProducoSimple c) {
		
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
