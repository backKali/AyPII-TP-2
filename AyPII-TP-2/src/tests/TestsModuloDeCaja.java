package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excepciones.EstadoInvalido;
import excepciones.NumeroInvalido;
import modulo.caja.ModuloDeCaja;
import modulo.caja.Ticket;
import modulo.gestion.Categorias;
import modulo.gestion.Component;
import modulo.gestion.Mesa;
import modulo.gestion.Producto;

import java.text.ParseException;
import java.util.*;

public class TestsModuloDeCaja {
	
	ModuloDeCaja caja;
	
	Producto cerveza;
	Producto gaseosa;
	Producto papas;
	Producto pizza;
	Producto hamburguesa;

	Mesa mesa1;
	Mesa mesa2;
	Mesa mesa3;
	
	@Before
	public void inicializadorVariables() throws NumeroInvalido, EstadoInvalido{
		cerveza = new Producto("cerveza", 30.0, 45.0, Categorias.BEBIDAS_CON_ALCOHOL);
		gaseosa = new Producto("gaseosa", 25.0, 40.0, Categorias.BEBIDAS_SIN_ALCOHOL);
		papas = new Producto("papas", 20.0, 50.0, Categorias.MINUTAS);
		pizza = new Producto("pizza", 40.0, 70.0, Categorias.PIZZAS);
		hamburguesa = new Producto("hamburguesa", 30.0, 50.0, Categorias.HAMBURGUESAS);
		
		mesa1 = new Mesa(1);
		mesa2 = new Mesa(2);
		mesa3 = new Mesa(3);
		
		mesa1.ocuparMesa();
		mesa2.ocuparMesa();
		mesa3.ocuparMesa();
		
		mesa1.registrarConsumicion(cerveza);
		mesa1.registrarConsumicion(pizza);
		
		mesa2.registrarConsumicion(gaseosa);
		mesa2.registrarConsumicion(hamburguesa);
		
		mesa3.registrarConsumicion(cerveza);
		mesa3.registrarConsumicion(papas);
		
		mesa1.desocuparMesa();
		mesa2.desocuparMesa();
		mesa3.desocuparMesa();
		
		caja = ModuloDeCaja.getInstance();
		
	}

	@Test
	public void testListarTodosLosTickets() throws NumeroInvalido, EstadoInvalido {
		
		//Esta devolviendo un solo Ticket, investigar por que
		System.out.println(caja.getListadoDeTickets());
		
	}
	
	@Test
	public void testListarTicketsDesdeHasta() throws NumeroInvalido, EstadoInvalido, ParseException {
		
		/*
		 * Lo constructores para Date con los dias estan fuera de uso, asi que hay que 
		 * hacer un adapter para convertir un String a Long. Aca parece estar la "papota":
		 * https://stackoverflow.com/questions/12473550/how-to-convert-string-date-to-long-millseconds
		 * 
		 * Hecho! Se llama convertirStringALong
		 */
		
		//Mismo que el anterior, esta devolviendo menos de lo que deberia
		caja.listarPorFechas("01-01-1970 00:00:00", "31-12-2015");
		
	}

}