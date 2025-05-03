package tp6.solicitudCredito;

import tp6.cliente.Cliente;

public class SolicitudCreditoPersonal extends SolicitudCredito{

	public SolicitudCreditoPersonal(Cliente cliente, double monto, int plazoMes) {
		super(cliente, monto, plazoMes);
	}

	@Override
	public boolean esAceptable() {
		return esIngresoAnualMenor() && this.esMontoCuotaParteMenorIngresoMensual(70);
	}

	private boolean esIngresoAnualMenor() {
		return this.getCliente().getSueldoNetoAnual() >= 15000;
	}

}
