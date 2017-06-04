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

	public void listarPorFechas(String desde, String hasta) {

	}

	public Map<String, Ticket> getListadoDeTickets() {
		return listadoDeTickets;
	}

	private void setListadoDeTickets(Map<String, Ticket> listadoDeTickets) {
		this.listadoDeTickets = listadoDeTickets;
	}
}
