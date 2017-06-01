package modulo.gestion;

public class Producto extends Component {

	private Categorias categoria;
	
	public Producto(String descripcion, Double precioDeCompra, Double precioDeVenta, Categorias categoria) {
		
		super(descripcion, precioDeCompra, precioDeVenta);
		this.categoria = categoria;
	}
	
	/**
	 * @return: Devuelve la categoria a la que pertenece el producto.
	 */
	public Categorias getCategoria() {
		
		return this.categoria;
	}

}
