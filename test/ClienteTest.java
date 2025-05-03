import org.junit.jupiter.api.*;


public class ClienteTest {
	
	Cliente cliente;
	ClienteManager cm;
	
	SolicitudCredito creditoPersona;
	
	Banco banco;
	BancoInternos bi;
	
	@BeforeEach
	public void setUp() {
		cm = new ClienteManager;
		cliente = new Cliente("Pedro", "Perez", "AAA 111", "20", "50000", cm);
		creditoPersonal = new SolicitudCreditoPersonal();
		
		banco = new Banco();;
		bi = new BancoInternos();
	}
	
	@Test
	public void solicitarCreditoTest() {
		//el credito es aceptado
		cliente.solicitarCredito();
		assertEquals(bi.creditosAceptados().getFirst(), creditoPersonal);
		
	}
	@Test
	public void sueldoNetoAnual() {
		assertEquals(600000, cliente.sueldoNetoAnual());
	}
	
}
