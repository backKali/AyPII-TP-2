package modulo.caja;

import java.util.*;
import modulo.gestion.Component;

public class ModuloDeCaja {

	private static ModuloDeCaja instance;
	private Map<String, Ticket> listadoDeTickets;

	public void generarTicket(Integer numeroDeMesa, Double montoTotal, LinkedList<Component> consumicionesDeLaMesa) {

		TreeSet<Component> consumiciones = new TreeSet<Component>();
		/*
		 * ver si esto reemplza al while de abajo
		 * consumiciones.addAll(consumicionesDeLaMesa);
		 */

		Iterator<Component> itr = consumicionesDeLaMesa.iterator();
		while (itr.hasNext()) {

			consumiciones.add(itr.next());
		}

		Ticket ticket;
		ticket = new Ticket(numeroDeMesa, montoTotal, consumiciones);

		this.listadoDeTickets.put(ticket.getFechaYHora(), ticket);

	}

	private ModuloDeCaja() {

		setListadoDeTickets(new TreeMap<String, Ticket>());
	}

	public static ModuloDeCaja getInstance() {

		if (instance == null) {

			instance = new ModuloDeCaja();
		}

		return instance;
	}

	// Hay que ver si los signos del compareTo estan bien
	// Tambien hay que ver que onda con que me marca eclipse en "Iterator" y "(Map.Entry)"

	/**
	 * Las fechas deben estar en el siguiente formato dia/mes/annio/ hora:minutos:segundos
	 * @param desde: desde donde se quiere obtener los Tickets emitidos.
	 * @param hasta: hasta donde se quiere obtener los Tickets emitidos.
	 * @return: devuelve los Tickets ordenados.
	 */
	public TreeMap<String, Ticket> listarPorFechas(String desde, String hasta) {

		TreeMap<String, Ticket> listadoPorFechas = new TreeMap<String, Ticket>();

		Iterator itr = listadoPorFechas.entrySet().iterator();

		while (itr.hasNext()) {

			Map.Entry<String, Ticket> e = (Map.Entry) itr.next();
			String s = e.getKey();

			if ((s.compareTo(desde) == 0)) {

				listadoPorFechas.put(desde, e.getValue());
			} else if (s.compareTo(hasta) == 0) {

				listadoPorFechas.put(hasta, e.getValue());
			} else if (s.compareTo(desde) > 0) {

				listadoPorFechas.put(desde, e.getValue());
			} else if (s.compareTo(hasta) < 0) {

				listadoPorFechas.put(hasta, e.getValue());
			}

		}

		return listadoPorFechas;
	}

	public Map<String, Ticket> getListadoDeTickets() {
		return listadoDeTickets;
	}

	private void setListadoDeTickets(Map<String, Ticket> listadoDeTickets) {
		this.listadoDeTickets = listadoDeTickets;
	}
}
