package tp6.solicitudCredito;

public class Propiedad {
	
	private String direccion;
	private double valor;
	
	public Propiedad(String direccion, double valor){
		this.direccion = direccion;
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}

}
