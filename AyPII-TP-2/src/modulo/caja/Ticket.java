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

	public Ticket(Integer numeroDeMesa, Double montoTotal, TreeSet<Component> comsumicones) {

		setNumeroDeTicket();
		setFechaYHora();
		setNumeroDeMesa(numeroDeMesa);
		setMontoTotal(montoTotal);
		listaDeConsumiciones.addAll(comsumicones);
	}

	/**
	 * @return: Devuelve la fecha y hora en que se emitio el Ticket.
	 */
	public String getFechaYHora() {
		return fechaYHora;
	}

	private void setFechaYHora() {

		// Lo que pusiste aca, creo que solo devuelve el dia mes y año,
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

		this.fechaYHora = t;

	}

	public Integer getNumeroDeMesa() {
		return numeroDeMesa;
	}

	private void setNumeroDeMesa(Integer numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	private void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Integer getNumeroDeTicket() {
		return numeroDeTicket;
	}

	private void setNumeroDeTicket() {

		this.numeroDeTicket = contador + 1;
	}

}
