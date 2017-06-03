package modulo.caja;

import java.util.*;

import modulo.gestion.Component;

public class ModuloDeCaja {

	private static ModuloDeCaja instance;
	private Ticket ticket;
	private Map<String, Ticket> listadoDeTickets;

	public void generarTicket(Integer numeroDeMesa, Double montoTotal, LinkedList<Component> consumiciones) {
		
		this.ticket = new Ticket(numeroDeMesa, montoTotal, consumiciones);
		
		this.listadoDeTickets.put("", ticket);

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
