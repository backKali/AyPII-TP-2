package modulo.caja;

import java.util.*;
import modulo.gestion.Component;

public class Ticket {

	private Integer numeroDeTicket;
	private Date fechaYHora;
	private Integer numeroDeMesa;
	private Double montoTotal;

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
	public Date getFechaYHora() {
		return fechaYHora;
	}

	/*
	 * Setea la fecha y hora con la del sistema.
	 */
	private void setFechaYHora() {

		Calendar calendario = new GregorianCalendar();

		this.fechaYHora = calendario.getTime();
		
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
