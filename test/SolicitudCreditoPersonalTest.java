import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SolicitudCreditoPersonalTest {
	
	
	Banco banco;
	BancoInternos bi;
	Cliente cliente;
	ClienteManager cm;
	
	SolicitudCredito creditoPersonal;
	Propiedad propi;
	
	@Nested
	class Aceptado {
		@BeforeEach
		public void setUp() {
			banco = new Banco();
			bi = new BancoInternos();
			cliente = new Cliente();
			cm = new ClienteManager();
			
			creditoPersonal = new SolicitudCreditoPersonal(cliente,1500000, 20);
		}
		
		@Test
		public void getMontoCuotaMensualAceptada() { // credito aceptado
			assertEquals(75000, creditoPersonal.getMontoCuotaMensual());
		}
		
		
		@Test
		public void esAceptada() {
			assertEquals(true, creditoPersonal.esAceptable());
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
		
		
		public void esRechazadoIngresoAnualTest() {
			cliente = new Cliente();	
			assertEquals(false, creditoPersonal.esAceptable());
		}
		
		public void esRechazadoIngresosMensualesTest() {
			cliente = new Cliente();	
			assertEquals(false, creditoPersonal.esAceptable());
		}
		
	}
	
}
