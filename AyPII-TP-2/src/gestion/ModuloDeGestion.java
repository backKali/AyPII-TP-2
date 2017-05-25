package gestion;

import java.util.*;

public class ModuloDeGestion {

	/**
	 * 
	 */
	private Set<Mesa> mesas;
	public static ModuloDeGestion instance;

	/**
	 * @param cantidadDeMesas:
	 *            Indica la cantidad de Mesas que poseerá el Bar.
	 * 
	 */
	private ModuloDeGestion(Integer cantidadDeMesas) {

		this.mesas = new TreeSet<Mesa>();

		int i = 0;

		while (i < cantidadDeMesas) {

			mesas.add(new Mesa(i + 1));
			i++;
		}
	}

	/**
	 * @param cantidadDeMesas:
	 *            Indica la cantidad de Mesas que poseerá el Bar.
	 * @return:
	 */
	public static ModuloDeGestion getInstance(Integer cantidadDeMesas) {

		if (instance == null) {

			instance = new ModuloDeGestion(cantidadDeMesas);
		}

		return instance;
	}

	/**
	 * @param numeroDeMesa:
	 *            Número de la Mesa que se quiere ocupar.
	 */
	public void ocuparMesa(Integer numeroDeMesa) {

		ocuparMesa(obtenerMesa(numeroDeMesa));
	}

	/**
	 * @param numeroDeMesa:
	 *            Número de la mesa que se quiere cerrar.
	 */
	public void cerrarUnaMesa(Integer numeroDeMesa) {

		cerrarUnaMesa(obtenerMesa(numeroDeMesa));
	}

	/**
	 * @param numeroDeMesa:
	 *            Número de la mesa que se quiere pasar a diponible.
	 */
	public void pasarUnaMesaAEstadoDisponible(Integer numeroDeMesa) {

		pasarUnaMesaAEstadoDisponible(obtenerMesa(numeroDeMesa));
	}

	/**
	 * @param numeroDeMesa:
	 *            Número de la mesa en la que se va a registrar una consumición.
	 * @param consumicion:
	 *            Indica lo que se va a consumir en la Mesa.
	 */
	public void registrarConsumicion(Integer numeroDeMesa, Component consumicion) {

		registrarConsumicion(obtenerMesa(numeroDeMesa), consumicion);
	}

	/**
	 * @param numero:
	 *            Número de la Mesa a obtener.
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
	 */
	private void cerrarUnaMesa(Mesa mesaACerrar) {

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
	 *            Mesa en la que se va a registrar una consumición.
	 * @param consumucion:
	 *            Indica la consumición a registrar.
	 */
	private void registrarConsumicion(Mesa mesa, Component consumucion) {

		mesa.registrarConsumicion(consumucion);
	}
}
