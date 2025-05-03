package tp6.banco;

import java.util.ArrayList;
import java.util.List;

import tp6.cliente.*;
import tp6.solicitudCredito.*;
public class Banco {
	
	private String nombre;
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<SolicitudCredito> creditos = new ArrayList<SolicitudCredito>();
	
	public Banco (String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public List<SolicitudCredito> getCreditos() {
		return creditos;
	}

	public void nuevaSolicitudCredito(SolicitudCredito solicitudCredito) {
		creditos.add(solicitudCredito);
	}
}
