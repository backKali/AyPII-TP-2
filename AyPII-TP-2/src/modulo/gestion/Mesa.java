package modulo.gestion;

import java.util.*;

public class Mesa {

	private Integer numero;
	private EstadoMesa estado;
	private LinkedList<Component> consumiciones;

	/**
	 * @param numeroDeMesa:
	 *            Indica el número que poseera la Mesa.
	 */
	public Mesa(Integer numeroDeMesa) {

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
	public void cerrarMesa() {

		setEstado(EstadoMesa.CERRADA);
	}

	/**
	 * Desocupa la Mesa.
	 */
	public void desocuparMesa() {

		setEstado(EstadoMesa.DISPONIBLE);
	}

	/**
	 * @param consumicion:
	 *            Indica la consumición realizada en la Mesa.
	 */
	public void registrarConsumicion(Component consumicion) {

		consumiciones.add(consumicion);
	}

	/**
	 * @return: Devuelve el estado en que se encuentra la Mesa.
	 */
	public EstadoMesa getEstado() {

		return this.estado;
	}
	
	public Double obtenerGastoDeLaMesa() {
		
		Double gastoDeLaMesa = 0.0d;
		
		Iterator<Component> itr = consumiciones.iterator();
		while(itr.hasNext()) {
			
			gastoDeLaMesa += itr.next().getPrecioDeVenta();
		}
		
		return gastoDeLaMesa;
	}
	
	/**
	 * @param estado: Indica el estado al que se desea pasar la Mesa.
	 */
	private void setEstado(EstadoMesa estado) {
		
		this.estado = estado;
	}
}
