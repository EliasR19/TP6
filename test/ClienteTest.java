import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

import tp6.banco.*;
import tp6.cliente.*;
import tp6.solicitudCredito.*;


public class ClienteTest {
	
	Cliente cliente;
	
	SolicitudCredito creditoPersonal;
	
	Banco banco;
	BancoInternos bi;
	
	@BeforeEach
	public void setUp() {
		banco = new Banco("Pepe´s Bank");
		
		cliente = new Cliente("Pepe", 46, 2000d, banco);
		creditoPersonal = new SolicitudCreditoPersonal(cliente,22000, 20);
		
		bi = new BancoInternos();
	}
	
	@Test
	public void solicitarCreditoTest() {
		//el credito es aceptado
		cliente.solicitarCredito(creditoPersonal);
		assertEquals(bi.creditosAceptados(banco.getCreditos()).getFirst(), creditoPersonal);
		
	}
	@Test
	public void sueldoNetoAnual() {
		assertEquals(24000d, cliente.getSueldoNetoAnual(), 0.1);
	}
	
}
