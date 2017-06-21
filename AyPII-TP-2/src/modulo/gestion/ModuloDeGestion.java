package modulo.gestion;

import java.util.*;

import excepciones.EstadoInvalidoException;
import excepciones.NumeroInvalidoException;

public class ModuloDeGestion {

	/**
	 *  @mesas: Las mesas que administrara el Modulo.
	 *  @instance: Restringe la creacion de mas de un ModuloDeGestion.
	 */
	private List<Mesa> mesas;
	public static ModuloDeGestion instance;

	/**
	 * Constructor privado al cual solo se puede acceder desde getInstance().
	 * 
	 * @param cantidadDeMesas:
	 *            Indica la cantidad de Mesas que poseer� el Bar.
	 */
	private ModuloDeGestion(Integer cantidadDeMesas) throws EstadoInvalidoException {

		this.mesas = new ArrayList<Mesa>();

		int i = 0;

		while (i < cantidadDeMesas) {

			mesas.add(new Mesa(i + 1));
			i++;
		}
	}

	/**
	 * Crea una instancia del ModuloDeGestion s�lo si todav�a no existe alguna.
	 * @param cantidadDeMesas:
	 *            Indica la cantidad de Mesas que poseer� el Bar.
	 * @retutn: Devuelve una instancia del ModuloDeGestion.
	 */
	public static ModuloDeGestion getInstance(Integer cantidadDeMesas) throws EstadoInvalidoException {

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
	 * @throws EstadoInvalidoException 
	 */
	public void cerrarUnaMesa(Integer numeroDeMesa) throws EstadoInvalidoException {

		cerrarUnaMesa(obtenerMesa(numeroDeMesa));
	}

	/**
	 * Pasa una Mesa al estado disponible.
	 * @param numeroDeMesa:
	 *            N�mero de la mesa que se quiere pasar a diponible.
	 * @throws NumeroInvalidoException 
	 */
	public void pasarUnaMesaAEstadoDisponible(Integer numeroDeMesa) throws NumeroInvalidoException {

		pasarUnaMesaAEstadoDisponible(obtenerMesa(numeroDeMesa));
	}

	/**
	 * Registra una consumicion en la Mesa.
	 * 
	 * @param numeroDeMesa:
	 *            N�mero de la mesa en la que se va a registrar una consumici�n.
	 * @param consumicion:
	 *            Indica lo que se va a consumir en la Mesa.
	 * @throws EstadoInvalidoException
	 */
	public void registrarConsumicion(Integer numeroDeMesa, Producto consumicion) throws EstadoInvalidoException {

		registrarConsumicion(obtenerMesa(numeroDeMesa), consumicion);
	}

	/**
	 * @param numero:
	 *            N�mero de la Mesa a obtener.
	 * @return: Devuelve la Mesa que posee ese numero.
	 */
	public Mesa obtenerMesa(Integer numero) {

		numero --;
		
		return mesas.get(numero);
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
	 * @throws EstadoInvalidoException 
	 */
	private void cerrarUnaMesa(Mesa mesaACerrar) throws EstadoInvalidoException {

		mesaACerrar.cerrarMesa();
	}

	/**
	 * @param mesa:
	 *            Mesa que se va a pasar a estado disponible.
	 * @throws NumeroInvalidoException 
	 */
	private void pasarUnaMesaAEstadoDisponible(Mesa mesa) throws NumeroInvalidoException {

		mesa.desocuparMesa();
	}

	/**
	 * @param mesa:
	 *            Mesa en la que se va a registrar una consumici�n.
	 * @param consumucion:
	 *            Indica la consumici�n a registrar.
	 * @throws EstadoInvalidoException 
	 */
	private void registrarConsumicion(Mesa mesa, Producto consumucion) throws EstadoInvalidoException {

		mesa.registrarConsumicion(consumucion);
	}
}
