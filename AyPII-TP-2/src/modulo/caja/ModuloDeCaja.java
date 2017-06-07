package modulo.caja;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import modulo.gestion.Component;

public class ModuloDeCaja {

	private static ModuloDeCaja instance;
	private TreeMap<Date, Ticket> listadoDeTickets;

	public void generarTicket(Integer numeroDeMesa, Double montoTotal, LinkedList<Component> consumicionesDeLaMesa) {

		LinkedList<Component> consumiciones = new LinkedList<Component>();
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

		setListadoDeTickets(new TreeMap<Date, Ticket>());
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
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashSet<Ticket> listarPorFechas(String stringDesde, String stringHasta) throws ParseException {
		
		Date desde = new Date(convertirStringALong(stringDesde));
		Date hasta = new Date(convertirStringALong(stringHasta));

		/*
		 * Segun lo que piden, no necesitamos ordenarlos (obvio que es preferible), pero para empezar a testear
		 * solamente voy a crear una lista y despues solamente cambiamos el objeto y deberia funcionar de la misma manera
		 * 
		 * Esto es lo que estaba antes:
		 *		TreeMap<String, Ticket> listadoPorFechas = new TreeMap<String, Ticket>();

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
 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		//Creo una lista para meter los Tickets
		HashSet<Ticket> listadoTicketsDesdeHasta = new HashSet<Ticket>();
		
		//Creo el iterador que va a recorrer el diccionario
		Iterator<Map.Entry<Date, Ticket>> iteradorListadoDeTickets = listadoDeTickets.entrySet().iterator();
		
		//Creo un booleano para no iterar toda la lista una vez que estoy por debajo de "desde"
		boolean menorADesde = false;
		
		//Mientras que haya siguiente y el valor del actual no sea menor a "desde"
		while (iteradorListadoDeTickets.hasNext() && !menorADesde ){
			
			//Voy al siguiente y ly guardo en entradaEvaluada
			Map.Entry<Date, Ticket> entradaEvaluada = (Map.Entry) iteradorListadoDeTickets.next();
			
			//Me quedo con la fecha de esta entrada del diccionario
			Date epochEvaluado = entradaEvaluada.getKey();
			System.out.println("epochEvaluado: " + epochEvaluado);
			System.out.println("fechaDesde: " + desde);
			System.out.println("fechaHasta: " + hasta);

			/*
			 * Segun la ayuda, da negativo si "desde" esta antes de "epochEvaluado", y positivo
			 * si pasa lo contrario ("desde" esta despues de "epochEvaluado"). Lo mismo para "hasta"
			 * y "epochEvaluado"
			 */
			if ((desde.compareTo(epochEvaluado) >= 0 || hasta.compareTo(epochEvaluado) <= 0)) {

				//Agrego los tickets que haya en esta definicion
				listadoTicketsDesdeHasta.add(entradaEvaluada.getValue());
				System.out.println("Entro al if de agregado de ticket");
			}
			
			//Si "epochEvaluado" es menor a desde, cambio "menorADesde" para no seguir evluando todas las entradas del diccionario
			if (epochEvaluado.before(desde)){
				System.out.println("Entro al if de epochEvaluado es menor a desde");
				menorADesde = !menorADesde;
			}
			
		}

		return listadoTicketsDesdeHasta;
	}

	private long convertirStringALong(String fecha) throws ParseException {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    Date fechaEnDate = formatoFecha.parse(fecha);
	    long milisegundos= fechaEnDate.getTime();
	    
	    return milisegundos;
	}

	public Map<Date, Ticket> getListadoDeTickets() {
		return listadoDeTickets;
	}

	private void setListadoDeTickets(TreeMap<Date, Ticket> listadoDeTickets) {
		this.listadoDeTickets = listadoDeTickets;
	}
}
