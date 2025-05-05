package tp6.solicitudCredito;
import tp6.cliente.*;


public abstract class SolicitudCredito {
	
	private Cliente cliente;
	private double monto;
	private int plazoMes;
	
	public SolicitudCredito(Cliente cliente, double monto, int plazoMes) {
		this.cliente = cliente;
		this.monto = monto;
		this.plazoMes = plazoMes;
	}
	
	
	public double getMontoCuotaMensual() {
		return monto / plazoMes;
	}
	
	public double getMonto() {
		return monto;
	}


	public Cliente getCliente() {
		return cliente;
	}


//hacerlo para que lo vea solo el package
	public  boolean esMontoCuotaParteMenorIngresoMensual(int porcentaje) {
		double porcentajeClienteSueldoMensual = (cliente.getSueldoNetoMensual() * porcentaje ) / 100;
		return this.getMontoCuotaMensual() < porcentajeClienteSueldoMensual;
	}
	public abstract boolean esAceptable();
	
	
}
