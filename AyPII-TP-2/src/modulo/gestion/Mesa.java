package modulo.gestion;

import java.util.*;

import excepciones.EstadoInvalido;
import modulo.caja.ModuloDeCaja;

public class Mesa {

	/**
	 * @numero: Indica el numero que posee la Mesa.
	 * @estado: Indica el estado en que se encuentra la Mesa.
	 * @consumiciones: Las consumiciones realizadas en la Mesa.
	 */
	private Integer numero;
	private EstadoMesa estado;
	private LinkedList<ProducoSimple> consumiciones;

	/**
	 * @param numeroDeMesa:
	 *            Indica el n�mero que poseera la Mesa.
	 */
	public Mesa(Integer numeroDeMesa) throws EstadoInvalido {

		this.numero = numeroDeMesa;
		setEstado(EstadoMesa.DISPONIBLE);
		this.consumiciones = new LinkedList<ProducoSimple>();
	}

	/**
	 * @return: Devuelve el n�mero de la Mesa.
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
	public void cerrarMesa() throws EstadoInvalido {

		if (getEstado() == EstadoMesa.DISPONIBLE) {

			setEstado(EstadoMesa.CERRADA);
		} else {

			throw new EstadoInvalido("Para Cerrar una mesa, debe estar en Disponible");
		}
	}

	/**
	 * Desocupa la Mesa.
	 */
	public void desocuparMesa() {

		if (this.estado == EstadoMesa.OCUPADA && !this.consumiciones.isEmpty()) {

			// Genera el ticket en caso que la mesa haya hecho una consumicion
			ModuloDeCaja.getInstance().generarTicket(this.getNumero(), this.obtenerGastoDeLaMesa(), this.consumiciones);
		}
		setEstado(EstadoMesa.DISPONIBLE);
	}

	/**
	 * @param consumicion:
	 *            Indica la consumici�n realizada en la Mesa.
	 * @throws EstadoInvalido
	 */
	public void registrarConsumicion(ProducoSimple consumicion) throws EstadoInvalido {

		if (this.getEstado() == EstadoMesa.OCUPADA) {

			consumiciones.add(consumicion);
		} else {

			throw new EstadoInvalido("La mesa debe estar ocupada para cargar una consumici�n");
		}
	}

	/**
	 * @return: Devuelve el estado en que se encuentra la Mesa.
	 */
	public EstadoMesa getEstado() {

		return this.estado;
	}

	/**
	 * Devuelve el gasto total realizado en la Mesa.
	 */
	public Double obtenerGastoDeLaMesa() {

		Double gastoDeLaMesa = 0.0d;

		Iterator<ProducoSimple> itr = consumiciones.iterator();
		while (itr.hasNext()) {

			gastoDeLaMesa += itr.next().getPrecioDeVenta();
		}

		return gastoDeLaMesa;
	}

	/**
	 * @param estado:
	 *            Indica el estado al que se desea pasar la Mesa.
	 */
	private void setEstado(EstadoMesa estado) {

		this.estado = estado;
	}
}
