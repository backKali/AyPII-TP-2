package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excepciones.NumeroInvalidoException;
import org.junit.Assert;
import modulo.gestion.Categorias;
import modulo.gestion.ProductoSimple;

public class TestsProductoSimple {

	ProductoSimple productoParaTest;
	
	@Before
	public void inicializaVariables() throws NumeroInvalidoException{
		
		productoParaTest = new ProductoSimple("Cerveza", 30.0, 45.0, Categorias.BEBIDAS_CON_ALCOHOL);
		
	}
	
	@Test
	public void testGetCategoria() {
		//inicializacion
		
		//operacion
		
		//evaluacion
		Assert.assertEquals(Categorias.BEBIDAS_CON_ALCOHOL, productoParaTest.getCategoria());
		
	}
	
	@Test
	public void testGetPrecioDeVenta(){
		//inicializacion
		
		//operacion
		
		//evaluacion
		Assert.assertEquals(45.0, productoParaTest.getPrecioDeVenta(), 0.0);

	}

}
