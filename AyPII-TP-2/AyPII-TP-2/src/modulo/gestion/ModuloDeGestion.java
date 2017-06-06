package modulo.gestion;

import java.util.*;

import excepciones.EstadoInvalido;

public class ModuloDeGestion {

	/**
	 * 
	 */
	private Set<Mesa> mesas;
	public static ModuloDeGestion instance;

	/**
	 * Constructor de la clase.
	 * @param cantidadDeMesas:
	 *            Indica la cantidad de Mesas que poseer� el Bar.
	 * @throws EstadoInvalido 
	 * 
	 */
	private ModuloDeGestion(Integer cantidadDeMesas) throws EstadoInvalido {

		this.mesas = new TreeSet<Mesa>();

		int i = 0;

		while (i < cantidadDeMesas) {

			mesas.add(new Mesa(i + 1));
			i++;
		}
	}

	/**
	 * @param cantidadDeMesas:
	 *            Indica la cantidad de Mesas que poseer� el Bar.
	 * @return:
	 * @throws EstadoInvalido 
	 */
	public static ModuloDeGestion getInstance(Integer cantidadDeMesas) throws EstadoInvalido {

		if (instance == null) {

			instance = new ModuloDeGestion(cantidadDeMesas);
		}

		return instance;
	}

	/**
	 * Ocupa una Mesa.
	 * @param numeroDeMesa:
	 *            N�mero de la Mesa que se quiere ocupar.
	 */
	public void ocuparMesa(Integer numeroDeMesa) {

		ocuparMesa(obtenerMesa(numeroDeMesa));
	}

	/**
	 * Cierra una Mesa.
	 * @param numeroDeMesa:
	 *            N�mero de la mesa que se quiere cerrar.
	 * @throws EstadoInvalido 
	 */
	public void cerrarUnaMesa(Integer numeroDeMesa) throws EstadoInvalido {

		cerrarUnaMesa(obtenerMesa(numeroDeMesa));
	}

	/**
	 * Pasa una Mesa al estado disponible.
	 * @param numeroDeMesa:
	 *            N�mero de la mesa que se quiere pasar a diponible.
	 */
	public void pasarUnaMesaAEstadoDisponible(Integer numeroDeMesa) {

		pasarUnaMesaAEstadoDisponible(obtenerMesa(numeroDeMesa));
	}

	/**
	 * Registra una consumicion en la Mesa.
	 * 
	 * @param numeroDeMesa:
	 *            N�mero de la mesa en la que se va a registrar una consumici�n.
	 * @param consumicion:
	 *            Indica lo que se va a consumir en la Mesa.
	 * @throws EstadoInvalido
	 */
	public void registrarConsumicion(Integer numeroDeMesa, Component consumicion) throws EstadoInvalido {

		registrarConsumicion(obtenerMesa(numeroDeMesa), consumicion);
	}

	/**
	 * @param numero:
	 *            N�mero de la Mesa a obtener.
	 * @return: Devuelve la Mesa que posee ese numero.
	 */
	private Mesa obtenerMesa(Integer numero) {

		Mesa mesa = null;

		Iterator<Mesa> itr = mesas.iterator();
		while (itr.hasNext()) {

			Mesa aux = itr.next();
			if (aux.getNumero() == numero) {

				mesa = aux;
				break;
			}
		}

		return mesa;
	}

	/**
	 * @param mesaAOcupar:
	 *            Mesa que se va a ocupar.
	 */
	private void ocuparMesa(Mesa mesaAOcupar) {

		mesaAOcupar.ocuparMesa();
	}

	/**
	 * @param mesaACerrar:
	 *            Mesa que se a cerrar.
	 * @throws EstadoInvalido 
	 */
	private void cerrarUnaMesa(Mesa mesaACerrar) throws EstadoInvalido {

		mesaACerrar.cerrarMesa();
	}

	/**
	 * @param mesa:
	 *            Mesa que se va a pasar a estado disponible.
	 */
	private void pasarUnaMesaAEstadoDisponible(Mesa mesa) {

		mesa.desocuparMesa();
	}

	/**
	 * @param mesa:
	 *            Mesa en la que se va a registrar una consumici�n.
	 * @param consumucion:
	 *            Indica la consumici�n a registrar.
	 * @throws EstadoInvalido 
	 */
	private void registrarConsumicion(Mesa mesa, Component consumucion) throws EstadoInvalido {

		mesa.registrarConsumicion(consumucion);
	}
}