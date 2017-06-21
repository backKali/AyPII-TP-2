package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.EstadoInvalidoException;
import excepciones.NumeroInvalidoException;
import modulo.gestion.Categorias;
import modulo.gestion.EstadoMesa;
import modulo.gestion.Mesa;
import modulo.gestion.ProductoSimple;

public class TestsMesa {
	
	Mesa mesaParaTestsUno;
	Mesa mesaParaTestsDos;
	Mesa mesaParaTestsMenosUno;
	Mesa mesaParaTestsMenosDos;
	
	ProductoSimple cerveza;
	
	@Before
	public void constructorVariables() throws EstadoInvalidoException, NumeroInvalidoException{
		mesaParaTestsUno = new Mesa(1);
		mesaParaTestsDos = new Mesa(2);
		mesaParaTestsMenosUno = new Mesa(-1);
		mesaParaTestsMenosDos = new Mesa(-2);
		
		cerveza = new ProductoSimple("Cerveza", 30.0, 45.0, Categorias.BEBIDAS_CON_ALCOHOL);
	}

	@Test
	public void pruebaGeneraUnaMesaConLinkedListVacia() throws NumeroInvalidoException {
		//inicializacion
		
		//operacion
		
		//evaluacion
		Assert.assertEquals(mesaParaTestsUno.obtenerGastoDeLaMesa(),0.0,0);
	}
	
	@Test
	public void pruebaGeneraUnaMesaConEstadoMesaDisponible(){
		//inicializacion
		
		//operacion

		//evaluacion
		Assert.assertEquals(mesaParaTestsUno.getEstado(),EstadoMesa.DISPONIBLE);
	}
	
	@Test
	public void pruebaGeneraUnaMesaConElNumeroCorrecto(){
		//inicializacion
		
		//operacion
		
		//evaluacion
		Assert.assertEquals(mesaParaTestsUno.getNumero(),1,0);
		Assert.assertEquals(mesaParaTestsDos.getNumero(),2,0);
	}
	
	@Test
	public void pruebaOcuparMesaPasaAOcupada(){
		//inicializacion
		
		//operacion
		mesaParaTestsUno.ocuparMesa();
		
		//evaluacion
		Assert.assertEquals(mesaParaTestsUno.getEstado(),EstadoMesa.OCUPADA);
	}
	
	@Test
	public void pruebaMetodoDesocuparMesaSinConsumicionesPasaADisponible() throws EstadoInvalidoException, NumeroInvalidoException{
		//inicializacion
		
		//operacion
		mesaParaTestsUno.ocuparMesa();
		mesaParaTestsUno.desocuparMesa();
		
		//evaluacion
		Assert.assertEquals(mesaParaTestsUno.getEstado(),EstadoMesa.DISPONIBLE);
	}
	
	@Test
	public void pruebaRegistrarConsumicion() throws EstadoInvalidoException, NumeroInvalidoException{
		//inicializacion
		
		//operacion
		mesaParaTestsUno.ocuparMesa();
		mesaParaTestsUno.registrarConsumicion(cerveza);
		
		//evaluacion
		Assert.assertEquals(mesaParaTestsUno.obtenerGastoDeLaMesa(),45.0,0);
	}
	
	@Test
	public void pruebaCerrarMesaConConsumicionesGeneraTicketYPasaADisponible() throws EstadoInvalidoException, NumeroInvalidoException{
		//inicializacion
		
		//operacion
		mesaParaTestsUno.ocuparMesa();
		mesaParaTestsUno.registrarConsumicion(cerveza);
		mesaParaTestsUno.desocuparMesa();
		
		//evaluacion
		
	}
	
	@Test (expected = EstadoInvalidoException.class)
	public void pruebaRegistrarConsumicionMientrasDesocupadaOCerrada() throws EstadoInvalidoException{
		//inicializacion
		
		//operacion
		mesaParaTestsUno.registrarConsumicion(cerveza);
		
		//evaluacion
		
	}
	
	@Test
	public void testGetNumero(){
		//inicializacion
		
		//operacion
		mesaParaTestsUno.getNumero();
		
		//evaluacion
		Assert.assertEquals(1, mesaParaTestsUno.getNumero(), 0);
	}
	
}