package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import excepciones.NumeroInvalido;
import modulo.caja.Ticket;
import modulo.gestion.Categorias;
import modulo.gestion.Component;
import modulo.gestion.Producto;

import java.util.*;

public class TestsTicket {

	@Test
	public void test() throws NumeroInvalido {
		
		LinkedList<Component> consumiciones = new LinkedList<Component>();
		Producto cerveza = new Producto("cerveza", 30.0, 45.0, Categorias.BEBIDAS_CON_ALCOHOL);
		consumiciones.add(cerveza);
		
		Ticket ticketTestsUno = new Ticket(1, 20.0, consumiciones);
		
		
	}

}