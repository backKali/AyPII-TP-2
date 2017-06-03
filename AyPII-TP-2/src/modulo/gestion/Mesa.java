package modulo.gestion;

import java.util.*;

import excepciones.EstadoInvalido;
import modulo.caja.ModuloDeCaja;

public class Mesa {

	private Integer numero;
	private EstadoMesa estado;
	private LinkedList<Component> consumiciones;

	/**
	 * @param numeroDeMesa:
	 *            Indica el número que poseerá la Mesa.
	 */
	public Mesa(Integer numeroDeMesa) throws EstadoInvalido {

		this.numero = numeroDeMesa;
		setEstado(EstadoMesa.DISPONIBLE);
		this.consumiciones = new LinkedList<Component>();
	}

	/**
	 * @return: Devuelve el número de la Mesa.
	 */
	public Integer getNumero() {

		return this.numero;
	}

	/**
	 * Ocupa la Mesa.
	 */
	public void ocuparMesa() {

		if (getEstado() == EstadoMesa.DISPONIBLE) {

			this.estado = EstadoMesa.OCUPADA;
		}
	}

	/**
	 * Cierra la Mesa.
	 */
	public void cerrarMesa() throws EstadoInvalido{

		if (getEstado() == EstadoMesa.DISPONIBLE){
			this.estado = EstadoMesa.CERRADA;
		} else {
			throw new EstadoInvalido("Para Cerrar una mesa, debe estar en Disponible");
		}
	}

	/**
	 * Desocupa la Mesa.
	 */
	public void desocuparMesa() throws EstadoInvalido{

		if (this.estado == EstadoMesa.OCUPADA && !this.consumiciones.isEmpty()){
			//Genera el ticket en caso que la mesa haya hecho una consumicion
			ModuloDeCaja.getInstance().generarTicket(this.getNumero(), this.obtenerGastoDeLaMesa(), this.consumiciones);
		}
		this.estado = EstadoMesa.DISPONIBLE;
	}

	/**
	 * @param consumicion:
	 *            Indica la consumición realizada en la Mesa.
	 * @throws EstadoInvalido 
	 */
	public void registrarConsumicion(Component consumicion) throws EstadoInvalido {

		if (this.getEstado() == EstadoMesa.OCUPADA){
			consumiciones.add(consumicion);
		} else {
			throw new EstadoInvalido("La mesa debe estar ocupada para cargar una consumición");
		}
		
	}

	/**
	 * @return: Devuelve el estado en que se encuentra la Mesa.
	 */
	public EstadoMesa getEstado() {

		return this.estado;
	}
	
	public Double obtenerGastoDeLaMesa() {
		
		Double gastoDeLaMesa = 0d;
		
		Iterator<Component> itr = consumiciones.iterator();
		while(itr.hasNext()) {
			
			gastoDeLaMesa += itr.next().getPrecioDeVenta();
		}
		
		return gastoDeLaMesa;
	}
	
	/**
	 * @param estado: Indica el estado al que se desea pasar la Mesa.
	 */
	private void setEstado(EstadoMesa estado) throws EstadoInvalido {
		
		if (estado == EstadoMesa.CERRADA){
			this.cerrarMesa();
		}
		if (estado == EstadoMesa.DISPONIBLE){
			this.desocuparMesa();
		}
		if (estado == EstadoMesa.OCUPADA){
			this.ocuparMesa();
		}
	}
}