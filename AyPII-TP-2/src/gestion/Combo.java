package gestion;

import java.util.*;

public class Combo extends Component {

	private Set<Component> productosDelCombo;
	private Integer descuento;
	
	public Combo(String descripcion, Integer descuento) {
		
		super(descripcion);
		setDescuento(descuento);
		this.productosDelCombo = new TreeSet<Component>();
		setPrecioDeCompra();
		setPrecioDeVenta();
	}
	
	/**
	 * @param descuento
	 */
	private void setDescuento(Integer descuento) {

		this.descuento = descuento;
	}
	
	/**
	 * @return:
	 */
	public Integer getDescuento() {
		
		return this.descuento;
	}

	/**
	 * @param producto: producto que se va a agregarAlCombo.
	 */
	public void agregarProductoAlCombo(Component producto) {
		
		this.productosDelCombo.add(producto);
	}
	
	/**
	 * @param combo: Combo que se va a agregar a este Combo.
	 */
	public void agregarComboAlCombo(Combo combo) {
		
		this.productosDelCombo.addAll(productosDelCombo);
	}
	
	/**
	 * Le asigna el precio de compra al Combo.
	 */
	private void setPrecioDeCompra() {
		
		Double precio = 0.0;	
		
		Iterator<Component> itr = productosDelCombo.iterator();
		while(itr.hasNext()) {
			precio += itr.next().precioDeCompra;
		}
		
		this.precioDeCompra = precio;
	}
	
	/**
	 * Le asigna un precio de venta al Combo con un descuento.
	 */
	private void setPrecioDeVenta() {

		Double precio = 0.0;	
		
		Iterator<Component> itr = productosDelCombo.iterator();
		while(itr.hasNext()) {
			precio += itr.next().precioDeVenta;
		}
		
		precio = precio * (1 - (this.descuento/100));
		
		this.precioDeVenta = precio;
		
	}
}
