import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

import tp6.banco.Banco;
import tp6.cliente.*;
import tp6.solicitudCredito.*;


public class SolicitudCreditoHipotecarioTest {

	Cliente cliente;
	
	SolicitudCredito creditoHipoteca;
	Propiedad propi;
	
	Banco banco = new Banco("BankGold");
	
	@Nested
	class Aceptado {
		@BeforeEach
		public void setUp() {
			cliente = new Cliente("Pepe", 22, 4000, banco);
			propi = new Propiedad("Calle Falsa 123", 100000);
			creditoHipoteca = new SolicitudCreditoHipotecario(cliente,15000, 8, propi);
		}
		
		@Test
		public void getMontoCuotaMensualAceptada() { // credito aceptado
			assertEquals(1875d, creditoHipoteca.getMontoCuotaMensual(), 0.1);
		}
		
		
		@Test
		public void esAceptada() {
			assertEquals(true, creditoHipoteca.esAceptable());
		}
	}
	
	@Nested 
	class Rechazado{
		@BeforeEach
		public void setUp() {
		}
		
		@Test
		public void esRechazadoEdadTest() {
			cliente = new Cliente("Jaun Salvo", 66, 4000, banco);	
			propi = new Propiedad("Calle Falsa 123", 100000);
			creditoHipoteca = new SolicitudCreditoHipotecario(cliente,15000, 8, propi);
			
			assertEquals(false, creditoHipoteca.esAceptable());
			
		}
		
		@Test
		public void esRechazadoValorPropiedadTest() {
			cliente = new Cliente("Jaun Salvo", 45, 4000, banco);	
			propi = new Propiedad("Calle Falsa 123", 10000);
			creditoHipoteca = new SolicitudCreditoHipotecario(cliente,15000, 8, propi);
			
			assertEquals(false, creditoHipoteca.esAceptable());
		}
		
		@Test
		public void esRechazadoMontoCuotaParteTest() {
			cliente = new Cliente("Jaun Salvo", 45, 4000, banco);	
			propi = new Propiedad("Calle Falsa 123", 100000);
			creditoHipoteca = new SolicitudCreditoHipotecario(cliente,15000, 3, propi);
			
			assertEquals(false, creditoHipoteca.esAceptable());
		}
		
	}
	
}
