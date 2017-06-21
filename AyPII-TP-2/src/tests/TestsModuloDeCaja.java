package tests;

import org.junit.Before;
import org.junit.Test;

import excepciones.EstadoInvalidoException;
import excepciones.NumeroInvalidoException;
import modulo.caja.ModuloDeCaja;
import modulo.gestion.Categorias;
import modulo.gestion.Mesa;
import modulo.gestion.ProductoSimple;

import java.text.ParseException;

public class TestsModuloDeCaja {

	ModuloDeCaja caja;

	ProductoSimple cerveza;
	ProductoSimple gaseosa;
	ProductoSimple papas;
	ProductoSimple pizza;
	ProductoSimple hamburguesa;

	Mesa mesa1;
	Mesa mesa2;
	Mesa mesa3;

	@Before
	public void inicializadorVariables() throws NumeroInvalidoException, EstadoInvalidoException {
		cerveza = new ProductoSimple("cerveza", 30.0, 45.0, Categorias.BEBIDAS_CON_ALCOHOL);
		gaseosa = new ProductoSimple("gaseosa", 25.0, 40.0, Categorias.BEBIDAS_SIN_ALCOHOL);
		papas = new ProductoSimple("papas", 20.0, 50.0, Categorias.MINUTAS);
		pizza = new ProductoSimple("pizza", 40.0, 70.0, Categorias.PIZZAS);
		hamburguesa = new ProductoSimple("hamburguesa", 30.0, 50.0, Categorias.HAMBURGUESAS);

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
	public void testListarTodosLosTickets() throws NumeroInvalidoException, EstadoInvalidoException {

		// Esta devolviendo un solo Ticket, investigar por que
		System.out.println(caja.getListadoDeTickets());

	}

	@Test
	public void testListarTicketsDesdeHasta() throws NumeroInvalidoException, EstadoInvalidoException, ParseException {

		caja.listarPorFechas("01-01-1970 00:00:00", "31-12-2015");

	}
	
}