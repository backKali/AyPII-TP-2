package modulo.gestion;

import excepciones.NumeroInvalido;

public class Producto extends Component implements Comparable<Component> {

	private Categorias categoria;

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
