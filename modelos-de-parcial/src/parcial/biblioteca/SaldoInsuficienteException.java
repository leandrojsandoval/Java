package parcial.biblioteca;

public class SaldoInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 8448309150570347998L;

	public SaldoInsuficienteException(String mensaje) {
		super(mensaje);
	}
}
