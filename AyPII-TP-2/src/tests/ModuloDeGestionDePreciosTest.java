package tests;

import org.junit.Test;
import java.util.*;
import excepciones.NumeroInvalido;
import modulo.gestion.*;
import modulo.precios.*;

public class ModuloDeGestionDePreciosTest {

	@Test
	public void test() throws NumeroInvalido {
		
		ModuloDeGestionDePrecios a = ModuloDeGestionDePrecios.getInstance();
		
		a.darDeAltaUnNuevoProcuto("Pizza", 45.0, 120.0, Categorias.PIZZAS);
		a.darDeAltaUnNuevoProcuto("Empanada", 7.0, 12.0, Categorias.MINUTAS);
		a.darDeAltaUnNuevoProcuto("Agua", 5.0, 10.0, Categorias.BEBIDAS_SIN_ALCOHOL);
		a.darDeAltaUnNuevoProcuto("Vodka", 35.0, 80.0, Categorias.BEBIDAS_CON_ALCOHOL);
		a.darDeAltaUnNuevoProcuto("Hamburguesa", 25.0, 50.0, Categorias.HAMBURGUESAS);

		TreeSet<ProducoSimple> s = new TreeSet<ProducoSimple>();
		Producto t1 = new Producto("Cerveza 250ml", 6.0, 35.0, Categorias.BEBIDAS_SIN_ALCOHOL);
		Producto t2 = new Producto("Pizza Chica", 22.0, 70.0, Categorias.PIZZAS);
		
		s.add(t1);
		s.add(t2);
		
		Combo c1 = new Combo("Pizza Individual", 12, s);
		
		
		a.agregarCombo(c1);
		
		a.imprimirCarta();
		
	}

}
