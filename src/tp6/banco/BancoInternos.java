package tp6.banco;

import java.util.List;
import java.util.stream.Collectors;

import tp6.solicitudCredito.*;

public class BancoInternos {
	
	public double getMontoTotalDesembolsar(List<SolicitudCredito> creditos) {
		return creditos.stream().mapToDouble(SolicitudCredito::getMonto).sum();
	}
	
	public List<SolicitudCredito> creditosAceptados(List<SolicitudCredito> creditos){
		return creditos.stream().filter(credito -> credito.esAceptable()).collect(Collectors.toList());
	}
	
	public List<SolicitudCredito> creditosRechazados(List<SolicitudCredito> creditos){
		return creditos.stream().filter(credito -> !credito.esAceptable()).collect(Collectors.toList());
	}
}
