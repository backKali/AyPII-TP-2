package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.EstadoInvalido;
import excepciones.NumeroInvalido;
import modulo.gestion.Categorias;
import modulo.gestion.EstadoMesa;
import modulo.gestion.Mesa;
import modulo.gestion.Producto;

public class TestsMesa {
	
	Mesa mesaParaTestsUno;
	Mesa mesaParaTestsDos;
	Mesa mesaParaTestsMenosUno;
	Mesa mesaParaTestsMenosDos;
	
	Producto cerveza;
	
	@Before
	public void constructorVariables() throws EstadoInvalido, NumeroInvalido{
		mesaParaTestsUno = new Mesa(1);
		mesaParaTestsDos = new Mesa(2);
		mesaParaTestsMenosUno = new Mesa(-1);
		mesaParaTestsMenosDos = new Mesa(-2);
		
		cerveza = new Producto("Cerveza", 30.0, 45.0, Categorias.BEBIDAS_CON_ALCOHOL);
	}

	@Test
	public void pruebaGeneraUnaMesaConLinkedListVacia() {
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
	public void pruebaMetodoDesocuparMesaSinConsumicionesPasaADisponible() throws EstadoInvalido{
		//inicializacion
		
		//operacion
		mesaParaTestsUno.ocuparMesa();
		mesaParaTestsUno.desocuparMesa();
		
		//evaluacion
		Assert.assertEquals(mesaParaTestsUno.getEstado(),EstadoMesa.DISPONIBLE);
	}
	
	@Test
	public void pruebaRegistrarConsumicion() throws EstadoInvalido{
		//inicializacion
		
		//operacion
		mesaParaTestsUno.ocuparMesa();
		mesaParaTestsUno.registrarConsumicion(cerveza);
		
		//evaluacion
		Assert.assertEquals(mesaParaTestsUno.obtenerGastoDeLaMesa(),45.0,0);
	}
	
	@Test
	public void pruebaCerrarMesaConConsumicionesGeneraTicketYPasaADisponible() throws EstadoInvalido{
		//inicializacion
		
		//operacion
		mesaParaTestsUno.ocuparMesa();
		mesaParaTestsUno.registrarConsumicion(cerveza);
		mesaParaTestsUno.desocuparMesa();
		
		//evaluacion
		
	}
	
	@Test (expected = EstadoInvalido.class)
	public void pruebaRegistrarConsumicionMientrasDesocupadaOCerrada() throws EstadoInvalido{
		//inicializacion
		
		//operacion
		mesaParaTestsUno.registrarConsumicion(cerveza);
		
		//evaluacion
		
	}
	
}