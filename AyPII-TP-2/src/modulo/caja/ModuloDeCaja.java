package modulo.caja;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import modulo.gestion.Component;

public class ModuloDeCaja {

	private static ModuloDeCaja instance;
	private Map<Date, Ticket> listadoDeTickets;

	/**
	 * @param numeroDeMesa:
	 *            Numero de la mesa de la cual se va a generar el Ticket.
	 * @param montoTotal:
	 *            Gasto total de la mesa.
	 * @param consumicionesDeLaMesa:
	 *            Lista de las consumiciones realizadas en la mesa.
	 */
	public void generarTicket(Integer numeroDeMesa, Double montoTotal, LinkedList<Component> consumicionesDeLaMesa) {

		TreeSet<Component> consumiciones = new TreeSet<Component>();

		consumiciones.addAll(consumicionesDeLaMesa);

		Ticket ticket;
		ticket = new Ticket(numeroDeMesa, montoTotal, consumiciones);

		this.listadoDeTickets.put(ticket.getFechaYHora(), ticket);

	}

	private ModuloDeCaja() {

		setListadoDeTickets(new TreeMap<Date, Ticket>());
	}

	public static ModuloDeCaja getInstance() {

		if (instance == null) {

			instance = new ModuloDeCaja();
		}

		return instance;
	}

	/**
	 * Las fechas deben estar en el siguiente formato dia/mes/annio/
	 * hora:minutos:segundos
	 * 
	 * @param desde:
	 *            desde donde se quiere obtener los Tickets emitidos.
	 * @param hasta:
	 *            hasta donde se quiere obtener los Tickets emitidos.
	 * @return: devuelve los Tickets ordenados.
	 */
	public TreeSet<Ticket> listarPorFechas(String stringDesde, String stringHasta) throws ParseException {

		Date desde = new Date(0L);
		Date hasta = new Date(0L);
		boolean huboErrorEnFecha = false;

		try {

			desde = new Date(convertirStringALong(stringDesde));
			hasta = new Date(convertirStringALong(stringHasta));
		} catch (ParseException mensaje) {

			System.out.println("El formato de la fecha debe ser: \"dd-MM-aaaa HH:mm:ss\"");
			huboErrorEnFecha = !huboErrorEnFecha;
		}

		// Creo una lista para meter los Tickets
		TreeSet<Ticket> listadoTicketsDesdeHasta = new TreeSet<Ticket>();

		// Creo el iterador que va a recorrer el diccionario
		Iterator<Map.Entry<Date, Ticket>> iteradorListadoDeTickets = listadoDeTickets.entrySet().iterator();

		// Creo un booleano para no iterar toda la lista una vez que estoy por
		// debajo de "desde"
		boolean menorADesde = false;

		// Mientras que haya siguiente y el valor del actual no sea menor a
		// "desde"
		while (iteradorListadoDeTickets.hasNext() && !menorADesde && !huboErrorEnFecha) {

			// Voy al siguiente y ly guardo en entradaEvaluada
			Map.Entry<Date, Ticket> entradaEvaluada = (Entry<Date, Ticket>) iteradorListadoDeTickets.next();

			// Me quedo con la fecha de esta entrada del diccionario
			Date epochEvaluado = entradaEvaluada.getKey();
			System.out.println("epochEvaluado: " + epochEvaluado);
			System.out.println("fechaDesde: " + desde);
			System.out.println("fechaHasta: " + hasta);

			/*
			 * Segun la ayuda, da negativo si "desde" esta antes de
			 * "epochEvaluado", y positivo si pasa lo contrario ("desde" esta
			 * despues de "epochEvaluado"). Lo mismo para "hasta" y
			 * "epochEvaluado"
			 */
			System.out.println(desde.compareTo(epochEvaluado));
			System.out.println(hasta.compareTo(epochEvaluado));
			if ((desde.compareTo(epochEvaluado) <= 0 && hasta.compareTo(epochEvaluado) >= 0)) {

				// Agrego los tickets que haya en esta definicion
				listadoTicketsDesdeHasta.add(entradaEvaluada.getValue());
				System.out.println("Entro al if de agregado de ticket");
			}

			// Si "epochEvaluado" es menor a desde, cambio "menorADesde" para no
			// seguir evluando todas las entradas del diccionario
			if (epochEvaluado.before(desde)) {
				System.out.println("Entro al if de epochEvaluado es menor a desde");
				menorADesde = !menorADesde;
			}

		}

		return listadoTicketsDesdeHasta;
	}

	private long convertirStringALong(String fecha) throws ParseException {

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date fechaEnDate = formatoFecha.parse(fecha);
		long milisegundos = fechaEnDate.getTime();

		return milisegundos;
	}

	public Map<Date, Ticket> getListadoDeTickets() {
		return listadoDeTickets;
	}

	private void setListadoDeTickets(Map<Date, Ticket> listadoDeTickets) {
		this.listadoDeTickets = listadoDeTickets;
	}
}
