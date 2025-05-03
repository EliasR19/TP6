package tp6.solicitudCredito;

import tp6.cliente.Cliente;

public class SolicitudCreditoHipotecario extends SolicitudCredito {
	
	private Propiedad propiedad;
	
	
	public SolicitudCreditoHipotecario(Cliente cliente, double monto, int plazoMes, Propiedad propiedad) {
		super(cliente, monto, plazoMes);
		this.propiedad = propiedad;
	}

	@Override
	public boolean esAceptable() {
		
		return this.esMontoCuotaParteMenorIngresoMensual(50) && esMontoSolicitadoMenorValorGarantia() && esEdadMenor(65) ;
	}

	private boolean esEdadMenor(int edad) {
		return this.getCliente().getEdad() < edad;
	}

	private boolean esMontoSolicitadoMenorValorGarantia() {
		double porcentajeGarantia = (this.propiedad.getValor() * 70 ) / 100;
		return this.getMonto() < porcentajeGarantia;
	}


}
