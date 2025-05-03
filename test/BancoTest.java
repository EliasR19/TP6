import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

import tp6.banco.*;
import tp6.cliente.*;
import tp6.solicitudCredito.*;

public class BancoTest {
	
	Banco banco;
	BancoInternos bi;
	
	SolicitudCredito creditoPersonal;
	
	Propiedad prop;
	SolicitudCredito creditoHipotecario;
	
	Cliente clienteA;
	Cliente clienteB;
	
	@Nested
	class CreditoAceptado {
		
		@BeforeEach
		public void setUp() {
			banco = new Banco("SOLO bank");
			bi =  new BancoInternos();
			
			clienteA = new Cliente("Elias", 21, 2000d, banco);
			creditoPersonal = new SolicitudCreditoPersonal(clienteA, 22000, 20);
			
			
			clienteB = new Cliente("Pepe", 22, 4000, banco);
			prop = new Propiedad("Calle Falsa 123", 100000);
			creditoHipotecario = new SolicitudCreditoHipotecario(clienteB ,15000, 8, prop);
			
		}
		
		@Test
		public void creditosAceptados() { 
			//son aceotados los dos creditos de diferente tipo
			banco.nuevaSolicitudCredito(creditoHipotecario);
			banco.nuevaSolicitudCredito(creditoPersonal);
			assertEquals(2, bi.creditosAceptados(banco.getCreditos()).size());
		}
		
		@Test
		public void montoTotalDesembolsar() {
			// tiene dos solicitudes acetadas
			banco.nuevaSolicitudCredito(creditoHipotecario);
			banco.nuevaSolicitudCredito(creditoPersonal);
			assertEquals(37000d, bi.getMontoTotalDesembolsar(banco.getCreditos()), 0.1);
		}
	
	}
	
	@Nested
	class CreditosRechazados {
	
		@BeforeEach
		public void setUp() {
			banco = new Banco("SOLO bank");
			bi =  new BancoInternos();
			
			clienteA = new Cliente("Elias", 21, 1000, banco);
			creditoPersonal = new SolicitudCreditoPersonal(clienteA, 22000, 20);
			
			clienteB = new Cliente("Pepe", 22, 4000, banco);
			prop = new Propiedad("Calle Falsa 123", 100000);
			creditoHipotecario = new SolicitudCreditoHipotecario(clienteB ,15000, 8, prop);
		}

		@Test
		public void unCreditoRechazado() {
			//Se rechaza el credito Personal
			banco.nuevaSolicitudCredito(creditoHipotecario);
			banco.nuevaSolicitudCredito(creditoPersonal);
			
			assertEquals(creditoPersonal, bi.creditosRechazados(banco.getCreditos()).getFirst());
		}
		
	}
	
}
