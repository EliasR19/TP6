import org.junit.jupiter.api.*;

public class BancoTest {
	
	Banco banco;
	BancoInternos bi;
	
	SolicitudCredito creditoPersonal;
	
	Propiedad prop;
	SolicitudCredito creditoHipotecario;
	
	Cliente cliente;
	
	
	class CreditoAceptado {
		
		@BeforeEach
		public void setUp() {
			banco = new Banco;
			bi =  new BancoInternos;
			cliente = new Cliente;
			
			creditoPersonal = new SolicitudCreditoPersonal(cliente, 20000, 8);
			
			prop = new Propiedad();
			creditoHipotecario = new SolicitudCreditoHipotecario(cliente, 50000, 13, prop);
			
		}
		
		@Test
		public void creditosAceptados() { 
			//son aceotados los dos creditos de diferente tipo
			banco.nuevaSolicitudCredito(creditoHipotecario);
			banco.nuevaSolicitudCredito(creditoPersonal);
			assertEquals(2, bi.creditosAceptados().size());
		}
		
		@public void montoTotalDesembolsar() {
			// tiene dos solicitudes acetadas
			banco.nuevaSolicitudCredito(creditoHipotecario);
			banco.nuevaSolicitudCredito(creditoPersonal);
			assertEquals(70000, bi.montoTotalDesembolsar);
		}
	
	}
	
	class CreditosRechazados {
	
		public void setUp() {
			banco = new Banco;
			bi =  new BancoInternos;
			cliente = new Cliente;
			
			creditoPersonal = new SolicitudCreditoPersonal(cliente, 20000, 8);
			
			prop = new Propiedad();
			creditoHipotecario = new SolicitudCreditoHipotecario(cliente, 50000, 13, prop);
		}
		
		@Test
		public void unCreditoRechazado() {
			//Se rechaza el credito Personal
			banco.nuevaSolicitudCredito(creditoHipotecario);
			banco.nuevaSolicitudCredito(creditoPersonal);
			
			assertEquals(creditoPersonal, bi.creditosRechazados().getFirst());
		}
		
	}
	
}
