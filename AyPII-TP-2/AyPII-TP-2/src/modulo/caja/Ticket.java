package modulo.caja;

import java.util.*;
import modulo.gestion.Component;

public class Ticket {

	private Integer numeroDeTicket;
	private String fechaYHora;
	private Integer numeroDeMesa;
	private Double montoTotal;

	// mati me dijo que esto no era necesario
	private TreeSet<Component> listaDeConsumiciones = new TreeSet<Component>();

	protected static Integer contador = 0;

	
	/**
	 * @param numeroDeMesa: Numero de la mesa a la cual se va a hacer el Ticket.
	 * @param consumiciones: Listado de lo consumido en la mesa.
	 */
	public Ticket(Integer numeroDeMesa, Double montoTotal, TreeSet<Component> consumiciones) {

		setNumeroDeTicket();
		setFechaYHora();
		setNumeroDeMesa(numeroDeMesa);
		setMontoTotal(montoTotal);
		listaDeConsumiciones.addAll(consumiciones);
	}

	/**
	 * @return: Devuelve la fecha y hora en que se emitio el Ticket.
	 */
	public String getFechaYHora() {
		return fechaYHora;
	}

	/*
	 * Setea la fecha y hora con la del sistema.
	 */
	private void setFechaYHora() {

		// Lo que pusiste aca, creo que solo devuelve el dia mes y a�o,
		// necesitamos tambien la hora

		String t = "";

		// Hay que ver cual nos sirve mas:

		Calendar calendario = new GregorianCalendar();

		int hora, minutos, segundos;

		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);

		String dia, mes, annio;

		dia = Integer.toString(calendario.get(Calendar.DATE));
		mes = Integer.toString(calendario.get(Calendar.MONTH));
		annio = Integer.toString(calendario.get(Calendar.YEAR));

		t = dia + "/" + mes + "/" + annio + "/" + " " + hora + ":" + minutos + ":" + segundos;

		// esto puede reemplazar a lo de arriba, fijate cual te gusta mas
		//
		// Date fecha = new Date();
		// t = fecha;
		// t = fecha.toString();
		//
		// devuelve algo asi: Sat Sep 24 21:07:36 CEST 2005

		/*
		 * Si, me di cuenta cuando corri un test y se rompio todo! Jaja! Hoy
		 * habia estado luchando un rato a la tarde y me parece que la mejor
		 * opcion es esa que pusiste vos (Calendar), porque ya tiene un
		 * compareTo que nos va a servir para el metodo de "desde" y "hasta". La
		 * unica duda que tengo es como manejar la fecha (si usar siempre el
		 * Calendar o un String y convertirlo cada vez que necesitemos)
		 *
		 * Nada, me parece que ma�ana me hago el enfermo en el laburo y le doy
		 * atomos asi para el Martes o Miercoles ya lo tenemos terminado (y no
		 * tenemos que andar corriendo como la otra vuelta a ultima hora ;)) Son
		 * estandares y no necesitamos mucho (solamente fecha y hora)
		 */

		this.fechaYHora = t;

	}

	/*
	 * Devuelve el numero de la mesa a la cual pertence el Ticket.
	 */
	public Integer getNumeroDeMesa() {
		return numeroDeMesa;
	}

	/*
	 * Asigna el numero de mesa al que pertenece el Ticket.
	 */
	private void setNumeroDeMesa(Integer numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}

	/*
	 * Devuelve el gasto total de la mesa.
	 */
	public Double getMontoTotal() {
		return montoTotal;
	}

	/*
	 * Asigna el gasto total de la mesa.
	 */
	private void setMontoTotal(Double montoTotal) {
		
		this.montoTotal = montoTotal;
	}

	/*
	 * Devuelve el numero de Ticket.
	 */
	public Integer getNumeroDeTicket() {
		return numeroDeTicket;
	}

	/*
	 * Asigna el numero que poseera el Ticket, el cual es unico.
	 */
	private void setNumeroDeTicket() {

		this.numeroDeTicket = contador + 1;
	}

}