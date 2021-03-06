package tests;

import java.util.TreeSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import excepciones.NumeroInvalidoException;
import modulo.gestion.*;
import modulo.precios.*;

public class TestsModuloDeGestionDePrecios {

	ModuloDeGestionDePrecios moduloDeGestionDePreciosParaTests;
    
	@Before
	public void inicializarVariables() throws NumeroInvalidoException{
		
		moduloDeGestionDePreciosParaTests = ModuloDeGestionDePrecios.getInstance();
		
		moduloDeGestionDePreciosParaTests.darDeAltaUnNuevoProducto("Pizza", 45.0, 120.0, Categorias.PIZZAS);
		moduloDeGestionDePreciosParaTests.darDeAltaUnNuevoProducto("Empanada", 7.0, 12.0, Categorias.MINUTAS);
		moduloDeGestionDePreciosParaTests.darDeAltaUnNuevoProducto("Agua", 5.0, 10.0, Categorias.BEBIDAS_SIN_ALCOHOL);
		moduloDeGestionDePreciosParaTests.darDeAltaUnNuevoProducto("Vodka", 35.0, 80.0, Categorias.BEBIDAS_CON_ALCOHOL);
		moduloDeGestionDePreciosParaTests.darDeAltaUnNuevoProducto("Hamburguesa", 25.0, 50.0, Categorias.HAMBURGUESAS);

	}
	
	@Test
	public void testConsultarDatosDeUnProductoPorDescripcion() throws NumeroInvalidoException {
		//inicializacion
		
		//operacion
		
		//evaluacion
		Assert.assertEquals("Empanada\n$ 12.0\n", moduloDeGestionDePreciosParaTests.consultarDatosDeUnProducto("Empanada"));
	}

	@Test
	public void testGenerarUnComboEImprimirCarta() throws NumeroInvalidoException{
		//inicializacion
		TreeSet<Producto> treeSetConPizza = new TreeSet<Producto>();
		ProductoSimple pizza = new ProductoSimple("Pizza", 45.0, 120.0, Categorias.PIZZAS);
		ProductoSimple empanada = new ProductoSimple("Empanada", 7.0, 12.0, Categorias.MINUTAS);
		treeSetConPizza.add(pizza);
		treeSetConPizza.add(empanada);
		
		//operacion
		moduloDeGestionDePreciosParaTests.generarUnCombo("Combo para Test", 10, treeSetConPizza);
		
		//evaluacion
		moduloDeGestionDePreciosParaTests.imprimirCarta();
	}
	
}
