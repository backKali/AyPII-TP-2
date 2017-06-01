package modulo.caja;

import java.util.*;

public class ModuloDeCaja {

	private static ModuloDeCaja instance;
	private Map<String, Ticket> listadoDeTickets;

	public void generarTicket() {

	}

	private ModuloDeCaja() {

		setListadoDeTickets(new TreeMap<String, Ticket>());
	}

	public ModuloDeCaja getInstance() {

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
