package modulo.caja;

import java.util.*;
import modulo.gestion.Component;

public class Ticket {
	
	private Integer numeroDeTicket;
	private String fechaYHora;
	private Integer numeroDeMesa;
	private Double montoTotal;
	
	//mati me dijo que esto no era necesario
	private TreeSet<Component> listaDeConsumiciones = new TreeSet<Component>();
	
	protected static Integer contador = 0;
	
	
	public Ticket(String fechaYHora, Integer numeroDeMesa, Double montoTotal, TreeSet<Component> comsumicones) {
		
		setNumeroDeTicket();
		setFechaYHora(fechaYHora);
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



	private void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
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
