package edu.unlam.paradigmas.colecciones.ej02;

public class FechaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FechaInvalidaException(String mensaje) {
		super(mensaje);
	}
}
