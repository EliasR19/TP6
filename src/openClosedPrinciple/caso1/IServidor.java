package openClosedPrinciple.caso1;

import java.util.List;

public interface IServidor {
	
	public List<Correo> recibirNuevos(String user, String pass);

	public void conectar(String nombreUsuario, String passusuario);

	public void enviar(Correo correo);
	
	public float tazaDeTransferencia();

	public void resetear();
	
	public void realizarBackUp();
	
	/*
	 * Interface Segregation Principle, una interfaz con muchas tareas. Preferible muchas interfaces que hacen pocas cosas.
	 * 
	 */

}
