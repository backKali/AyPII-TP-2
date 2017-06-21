package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.EstadoInvalidoException;
import excepciones.NumeroInvalidoException;
import modulo.gestion.Categorias;
import modulo.gestion.EstadoMesa;
import modulo.gestion.ModuloDeGestion;
import modulo.gestion.ProductoSimple;

public class TestsModuloDeGestion {

	ModuloDeGestion moduloDeGestionParaTests;
	
	ProductoSimple cerveza;
	
	@Before
	public void inicializarVariables() throws EstadoInvalidoException, NumeroInvalidoException{
		
		moduloDeGestionParaTests = ModuloDeGestion.getInstance(10);
		
		cerveza = new ProductoSimple("Cerveza", 30.0, 45.0, Categorias.BEBIDAS_CON_ALCOHOL);
		
	}
	
	@Test
	public void pruebaCerrarUnaMesa() throws EstadoInvalidoException{
		//inicializacion
		
		//operacion
		moduloDeGestionParaTests.cerrarUnaMesa(2);
		
		//evaluacion
		Assert.assertEquals(EstadoMesa.CERRADA, moduloDeGestionParaTests.obtenerMesa(2).getEstado());

	}
	
	@Test
	public void pruebaOcuparMesaYObtenerMesa() {
		//inicializacion
		
		//operacion
		moduloDeGestionParaTests.ocuparMesa(1);
		
		//evaluacion
		Assert.assertEquals(EstadoMesa.OCUPADA, moduloDeGestionParaTests.obtenerMesa(1).getEstado());
		
	}
	
	@Test
	public void pruebaPasarUnaMesaAEstadoDisponible() throws NumeroInvalidoException{
		//inicializacion
		
		//operacion
		moduloDeGestionParaTests.pasarUnaMesaAEstadoDisponible(2);
		
		//evaluacion
		Assert.assertEquals(EstadoMesa.DISPONIBLE, moduloDeGestionParaTests.obtenerMesa(2).getEstado());

	}
	
	@Test
	public void pruebaRegistrarConsumicion() throws EstadoInvalidoException, NumeroInvalidoException{
		//inicializacion
		moduloDeGestionParaTests.ocuparMesa(1);
		
		//operacion
		moduloDeGestionParaTests.registrarConsumicion(1, cerveza);
		
		//evaluacion
		Assert.assertEquals(45.0,moduloDeGestionParaTests.obtenerMesa(1).obtenerGastoDeLaMesa(),0);;

	}


}
