package modulo.gestion;

import java.util.*;

import excepciones.EstadoInvalidoException;
import excepciones.NumeroInvalidoException;
import modulo.caja.ModuloDeCaja;

public class Mesa {

	/**
	 * @numero: Indica el numero que posee la Mesa.
	 * @estado: Indica el estado en que se encuentra la Mesa.
	 * @consumiciones: Las consumiciones realizadas en la Mesa.
	 */
	private Integer numero;
	private EstadoMesa estado;
	private LinkedList<Producto> consumiciones;

	/**
	 * @param numeroDeMesa:
	 *            Indica el n�mero que poseera la Mesa.
	 */
	public Mesa(Integer numeroDeMesa) throws EstadoInvalidoException {

		this.numero = numeroDeMesa;
		setEstado(EstadoMesa.DISPONIBLE);
		this.consumiciones = new LinkedList<Producto>();
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
	public void cerrarMesa() throws EstadoInvalidoException {

		if (getEstado() == EstadoMesa.DISPONIBLE) {

			setEstado(EstadoMesa.CERRADA);
		} else {

			throw new EstadoInvalidoException("Para Cerrar una mesa, debe estar en Disponible");
		}
	}

	/**
	 * Desocupa la Mesa.
	 * @throws NumeroInvalidoException 
	 */
	public void desocuparMesa() throws NumeroInvalidoException {

		if (this.estado == EstadoMesa.OCUPADA && !this.consumiciones.isEmpty()) {

			// Genera el ticket en caso que la mesa haya hecho una consumicion
			ModuloDeCaja.getInstance().generarTicket(this.getNumero(), this.obtenerGastoDeLaMesa(), this.consumiciones);
		}
		setEstado(EstadoMesa.DISPONIBLE);
	}

	/**
	 * @param consumicion:
	 *            Indica la consumici�n realizada en la Mesa.
	 * @throws EstadoInvalidoException
	 */
	public void registrarConsumicion(Producto consumicion) throws EstadoInvalidoException {

		if (this.getEstado() == EstadoMesa.OCUPADA) {

			consumiciones.add(consumicion);
		} else {

			throw new EstadoInvalidoException("La mesa debe estar ocupada para cargar una consumici�n");
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
	 * @throws NumeroInvalidoException 
	 */
	public Double obtenerGastoDeLaMesa() throws NumeroInvalidoException {

		Double gastoDeLaMesa = 0.0;

		Iterator<Producto> itr = consumiciones.iterator();
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

	public LinkedList<Producto> getConsumiciones() {
		
		return consumiciones;
	}
}
