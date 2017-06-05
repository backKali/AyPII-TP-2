package modulo.caja;

import java.util.*;

import excepciones.FechaInvalida;
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

	public void listarPorFechas(String desde, String hasta) throws FechaInvalida {
		
		if (validarFormatoFecha(desde) && validarFormatoFecha(hasta)){
			
		} else {
			throw new FechaInvalida("El formato de fecha debe ser \"dd-mm-aaaa HH:mm:ss\"");
		}
	}

	public Map<String, Ticket> getListadoDeTickets() {
		return listadoDeTickets;
	}

	private void setListadoDeTickets(Map<String, Ticket> listadoDeTickets) {
		this.listadoDeTickets = listadoDeTickets;
	}
	
	private boolean validarFormatoFecha(String fecha){
		boolean esFechaValida = false;
		
		char[] charsFecha = fecha.toCharArray();
		
		if ( charsFecha[2] == '-' || charsFecha[5] == '-' || charsFecha[10] == ' ' || charsFecha[13] == ':' || charsFecha[16] == ':'
				&& charsFecha.length == 19
				&& fecha.replaceAll("\\D+", "").length() == 14){
			esFechaValida = !esFechaValida;
		}
		return esFechaValida;
	}
	
}
