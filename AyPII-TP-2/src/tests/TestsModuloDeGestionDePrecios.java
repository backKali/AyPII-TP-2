package tests;

import java.io.*;
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
	public void testConsultarDatosDeUnProductoPorCodigo() throws NumeroInvalidoException {
		//inicializacion
		
		//operacion
		
		//evaluacion
		Assert.assertEquals("Empanada\n$ 12.0\n", moduloDeGestionDePreciosParaTests.consultarDatosDeUnProducto(1));
	}
	
	@Test
	public void testGenerarUnComboEImprimirCarta() throws NumeroInvalidoException{
		//inicializacion
		TreeSet<Producto> treeSetConEmpanada = new TreeSet<Producto>();
		ProductoSimple empanada = new ProductoSimple("Empanada", 7.0, 12.0, Categorias.MINUTAS);
		treeSetConEmpanada.add(empanada);
		
		//operacion
		moduloDeGestionDePreciosParaTests.generarUnCombo("Combo para Test", 10, treeSetConEmpanada);
		
		//evaluacion
		moduloDeGestionDePreciosParaTests.imprimirCarta();
	}
//	TreeSet<Producto> s = new TreeSet<Producto>();
//	ProductoSimple t1 = new ProductoSimple("Cerveza 250ml", 6.0, 35.0, Categorias.BEBIDAS_SIN_ALCOHOL);
//	ProductoSimple t2 = new ProductoSimple("Pizza Chica", 22.0, 70.0, Categorias.PIZZAS);
//	
//	s.add(t1);
//	s.add(t2);
//	
//	Combo c1 = new Combo("Pizza Individual", 12, s);
//	
//	
//	a.agregarCombo(c1);
//	
//	a.imprimirCarta();
//	
}
