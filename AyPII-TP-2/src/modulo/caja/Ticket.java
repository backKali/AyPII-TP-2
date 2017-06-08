package modulo.caja;

import java.util.*;
import modulo.gestion.ProducoSimple;

public class Ticket {

	/**
	 * @numeroDeTicket: Numero unico que posee el Ticket.
	 * @fechaYHora: Fecha y hora en la que se emitio el Ticket.
	 * @numeroDeMesa: Indica el numero de Mesa al que pertenece el Ticket.
	 * @montoTotal: Indica el gasto total realizado en la Mesa.
	 */
	private Integer numeroDeTicket;
	private Date fechaYHora;
	private Integer numeroDeMesa;
	private Double montoTotal;

	/**
	 * @listadoDeConsumiciones: Las consumiciones realizadas en la Mesa.
	 * @contador: Usado para indicar el numero de Ticket.
	 */
	private TreeSet<ProducoSimple> listaDeConsumiciones = new TreeSet<ProducoSimple>();
	protected static Integer contador = 0;

	/**
	 * @param numeroDeMesa:
	 *            Numero de la Mesa a la cual se va a hacer el Ticket.
	 * @param consumiciones:
	 *            Listado de lo consumido en la Mesa.
	 */
	public Ticket(Integer numeroDeMesa, Double montoTotal, TreeSet<ProducoSimple> consumiciones) {

		setNumeroDeTicket();
		setFechaYHora();
		setNumeroDeMesa(numeroDeMesa);
		setMontoTotal(montoTotal);
		listaDeConsumiciones.addAll(consumiciones);
	}

	/**
	 * @return: Devuelve la fecha y hora en que se emitio el Ticket.
	 */
	public Date getFechaYHora() {
		return fechaYHora;
	}

	/*
	 * Asigna la fecha y hora en la que se emito el Ticket.
	 */
	private void setFechaYHora() {

		Calendar calendario = new GregorianCalendar();

		this.fechaYHora = calendario.getTime();

	}

	/*
	 * Devuelve el numero de la Mesa a la cual pertence el Ticket.
	 */
	public Integer getNumeroDeMesa() {
		return numeroDeMesa;
	}

	/*
	 * Asigna el numero de Mesa al que pertenece el Ticket.
	 */
	private void setNumeroDeMesa(Integer numeroDeMesa) {
		this.numeroDeMesa = numeroDeMesa;
	}

	/*
	 * Devuelve el gasto total de la Mesa.
	 */
	public Double getMontoTotal() {
		return montoTotal;
	}

	/*
	 * Asigna el gasto total de la Mesa.
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
