package modulo.gestion;

import java.util.*;

import excepciones.NumeroInvalido;

public class Combo extends Component {

	private Set<Component> productosDelCombo;
	private Integer descuento;
	
	public Combo(String descripcion, Integer descuento) throws NumeroInvalido{
		
		super(descripcion);
		setDescuento(descuento);
		this.productosDelCombo = new TreeSet<Component>();
		setPrecioDeCosto();
		setPrecioDeVenta();
	}
	
	/**
	 * @param descuento
	 */
	private void setDescuento(Integer descuento) throws NumeroInvalido{

		if (descuento >=0 && descuento<100){
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
	private void setPrecioDeCosto() {
		
		Double precio = 0.0;
		
		Iterator<Component> itr = productosDelCombo.iterator();
		while(itr.hasNext()) {
			precio += itr.next().precioDeCosto;
		}
		
		this.precioDeCosto = precio;
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