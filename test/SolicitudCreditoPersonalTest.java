import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import tp6.banco.Banco;
import tp6.cliente.*;
import tp6.solicitudCredito.*;
public class SolicitudCreditoPersonalTest {
	

	Cliente cliente;

	
	SolicitudCredito creditoPersonal;
	Propiedad propi;
	
	Banco banco = new Banco("Pepe´s Bank");
	
	@Nested 
	class Aceptado {
		@BeforeEach
		public void setUp() {

			cliente = new Cliente("Pepe", 46, 2000d, banco);

			creditoPersonal = new SolicitudCreditoPersonal(cliente,22000, 20);
		}
		
		@Test
		public void getMontoCuotaMensualAceptada() { // credito aceptado
			assertEquals(1100d, creditoPersonal.getMontoCuotaMensual(), 0.1);
		}
		
		
		@Test
		public void esAceptada() {
			assertEquals(true, creditoPersonal.esAceptable());
		}
	}
	
	@Nested
	class Rechazado{
		@BeforeEach
		public void setUp() {
		}
		
		@Test
		public void esRechazadoIngresoAnualTest() {
			cliente = new Cliente("Alicia", 32, 2000, banco);
			creditoPersonal = new SolicitudCreditoPersonal(cliente, 50000, 7);
			assertEquals(false, creditoPersonal.esAceptable());
		}
		
		@Test 
		public void esRechazadoIngresosMensualesTest() {
			cliente = new Cliente("Alicia", 32, 1000, banco);	
			creditoPersonal = new SolicitudCreditoPersonal(cliente, 5000, 7);
			assertEquals(false, creditoPersonal.esAceptable());
		}
		
	}
	
}
