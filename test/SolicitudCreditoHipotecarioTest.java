import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

public class SolicitudCreditoHipotecarioTest {
	
	Banco banco;
	BancoInternos bi;
	Cliente cliente;
	ClienteManager cm;
	
	SolicitudCredito creditoHipoteca;
	Propiedad propi;
	
	@Nested
	class Aceptado {
		@BeforeEach
		public void setUp() {
			banco = new Banco();
			bi = new BancoInternos();
			cliente = new Cliente();
			cm = new ClienteManager();
			
			propi = new Propiedad("Calle Falsa 123", 10000);
			creditoHipoteca = new SolicitudCreditoHipotecario(cliente,1500000, 20, propi);
		}
		
		@Test
		public void getMontoCuotaMensualAceptada() { // credito aceptado
			assertEquals(75000, creditoHipoteca.getMontoCuotaMensual());
		}
		
		
		@Test
		public void esAceptada() {
			assertEquals(true, creditoHipoteca.esAceptable());
		}
	}
	
	@Nestes
	class Rechazado{
		@BeforeEach
		public void setUp() {
			banco = new Banco();
			bi = new BancoInternos();
			cm = new ClienteManager();
		}
		
		public void esRechazadoEdadTest() {
			cliente = new Cliente();	
			propi = new Propiedad("Calle Falsa 123", 10000);
			creditoHipoteca = new SolicitudCreditoHipotecario(cliente,1500000, 20, propi);
			
			assertEquals(false, creditoHipoteca.esAceptable());
			
		}
		
		public void esRechazadoValorPropiedadTest() {
			cliente = new Cliente();	
			propi = new Propiedad("Calle Falsa 123", 10000);
			creditoHipoteca = new SolicitudCreditoHipotecario(cliente,1500000, 20, propi);
			
			assertEquals(false, creditoHipoteca.esAceptable());
		}
		
		public void esRechazadoMontoCuotaParteTest() {
			cliente = new Cliente();	
			propi = new Propiedad("Calle Falsa 123", 10000);
			creditoHipoteca = new SolicitudCreditoHipotecario(cliente,1500000, 20, propi);
			
			assertEquals(false, creditoHipoteca.esAceptable());
		}
		
	}
	
}
