package tests;

import org.junit.Assert;

import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import excepciones.NumeroInvalidoException;
import modulo.gestion.Categorias;
import modulo.gestion.Combo;
import modulo.gestion.Producto;
import modulo.gestion.ProductoSimple;

public class TestsCombo {
	
	Combo comboTestsVacio;
	Combo comboTestsConProductosSimples;
	Combo comboTestsConCombos;
	TreeSet<Producto> treeSetVacio = new TreeSet<Producto>();
	
	ProductoSimple cerveza;
	ProductoSimple gaseosa;
	ProductoSimple papas;
	ProductoSimple pizza;
	ProductoSimple hamburguesa;
	
	@Before
	public void inicializacionVariables() throws NumeroInvalidoException{
		
		papas = new ProductoSimple("papas", 20.0, 50.0, Categorias.MINUTAS);
		cerveza = new ProductoSimple("Cerveza", 30.0, 45.0, Categorias.BEBIDAS_CON_ALCOHOL);
		gaseosa = new ProductoSimple("gaseosa", 25.0, 40.0, Categorias.BEBIDAS_SIN_ALCOHOL);
		pizza = new ProductoSimple("pizza", 40.0, 70.0, Categorias.PIZZAS);
		hamburguesa = new ProductoSimple("hamburguesa", 30.0, 50.0, Categorias.HAMBURGUESAS);
		
		comboTestsVacio = new Combo("Combo vacio", 10, treeSetVacio);
		comboTestsConProductosSimples = new Combo("Combo con ProductosSimples", 10, treeSetVacio);
		comboTestsConCombos = new Combo("Combo con Combos", 10, treeSetVacio);
		
		comboTestsConProductosSimples.agregarProductoAlCombo(cerveza);
		comboTestsConProductosSimples.agregarProductoAlCombo(pizza);
		
		comboTestsConCombos.agregarComboAlCombo(comboTestsConProductosSimples);
	}

	@Test
	public void pruebaCreacionCorrectaDeUnComboConProductosSimples() throws NumeroInvalidoException {
		//inicializacion
		TreeSet<Producto> treeSetConProductosSimples = new TreeSet<Producto>();
		treeSetConProductosSimples.add(cerveza);
		Combo comboTestCreacionCorrectaConSimple = new Combo("Combo con ProductosSimples", 10, treeSetConProductosSimples);
		
		//operacion
		Double precioDeVenta = comboTestCreacionCorrectaConSimple.getPrecioDeVenta(comboTestCreacionCorrectaConSimple);
		
		//comparacion
		Assert.assertEquals(40.5, precioDeVenta, 0.0);
		
	}
	
	@Test
	public void pruebaMetodoGetProductosDelCombo(){
		//inicializacion
		TreeSet<Producto> productosQueDeberiaTener = new TreeSet<Producto>();
		productosQueDeberiaTener.add(cerveza);
		productosQueDeberiaTener.add(pizza);
		
		//operacion
		TreeSet<Producto> productosQueTiene = comboTestsConProductosSimples.getProductosDelCombo();
		
		//comparacion
		Assert.assertEquals(productosQueDeberiaTener, productosQueTiene);
	}
	
	@Test
	public void pruebaMetodoGetDescuento(){
		//inicializacion
		
		//operacion
		
		//comparacion
		Assert.assertEquals(10, comboTestsConProductosSimples.getDescuento(), 0);
		
	}
	
	@Test
	public void pruebaAgregarProductoAlCombo(){
		//inicializacion
		TreeSet<Producto> productosQueDeberiaTener = new TreeSet<Producto>();
		productosQueDeberiaTener.add(cerveza);
		productosQueDeberiaTener.add(pizza);
		productosQueDeberiaTener.add(papas);
		
		//operacion
		comboTestsConProductosSimples.agregarProductoAlCombo(papas);
		TreeSet<Producto> productosQueTiene = comboTestsConProductosSimples.getProductosDelCombo();
		
		//comparacion
		Assert.assertEquals(productosQueTiene, productosQueDeberiaTener);
	}
	
	@Test
	public void pruebaAgregarComboAlCombo() throws NumeroInvalidoException{
		//inicializacion
		TreeSet<Producto> productosQueDeberiaTener = new TreeSet<Producto>();
		productosQueDeberiaTener.add(cerveza);
		productosQueDeberiaTener.add(pizza);
		productosQueDeberiaTener.add(gaseosa);
		productosQueDeberiaTener.add(hamburguesa);
		
		TreeSet<Producto> productosQueSeAgregan = new TreeSet<Producto>();
		productosQueSeAgregan.add(gaseosa);
		productosQueSeAgregan.add(hamburguesa);
		
		Combo comboAAgregar = new Combo("Combo que se va a agregar en el test", 10, productosQueSeAgregan);
		
		//operacion
		comboTestsConProductosSimples.agregarComboAlCombo(comboAAgregar);
		TreeSet<Producto> productosQueTiene = comboTestsConProductosSimples.getProductosDelCombo();
		
		//comparacion
		Assert.assertEquals(productosQueDeberiaTener, productosQueTiene);
		
	}
	
	@Test
	public void pruebaGetPrecioDeVenta() throws NumeroInvalidoException{
		//inicializacion
		
		//operacion
		
		//comparacion
		Assert.assertEquals(103.5, comboTestsConProductosSimples.getPrecioDeVenta(comboTestsConProductosSimples), 0.0);
	}
	
	@Test
	public void pruebaGetCategoria(){
		//inicializacion
		
		//operacion
		
		//comparacion
		Assert.assertEquals(Categorias.COMBOS, comboTestsConProductosSimples.getCategoria());
	}
	
	@Test
	public void pruebaToString(){
		//inicializacion
		
		//operacion
		
		//comparacion
		Assert.assertEquals("Combo con ProductosSimples\n$ 103.5\nEl Combo incluye: Cerveza pizza\n", comboTestsConProductosSimples.toString());
	}

}