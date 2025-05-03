package tp6.cliente;
import tp6.*;
import tp6.banco.*;
import tp6.solicitudCredito.SolicitudCredito;

public class Cliente {
	private String nombre;
	private String apellido;
	private String direccion;
	private int edad;
	private double sueldoNetoMensual;
	private Banco banco;
	
	public Cliente(String nombre, int edad, double sueldoNetoMensual, Banco banco) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldoNetoMensual = sueldoNetoMensual;
		this.banco = banco;
	}
	
	public double getSueldoNetoAnual() {
		return sueldoNetoMensual * 12;
	}

	public int getEdad() {
		return edad;
	}

	public double getSueldoNetoMensual() {
		return sueldoNetoMensual;
	}
	
	public void solicitarCredito(SolicitudCredito credito) {
		banco.nuevaSolicitudCredito(credito);
	}
	
	// se deberia crear una instancia del credito cuando se pide la solicitud?
}
