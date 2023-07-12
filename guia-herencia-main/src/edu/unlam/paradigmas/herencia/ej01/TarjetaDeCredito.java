package edu.unlam.paradigmas.herencia.ej01;

import java.math.BigDecimal;

public class TarjetaDeCredito {

	private int numero;
	private Cuenta cuentaAsociada;
	private BigDecimal totalCompras;

	public TarjetaDeCredito(int numero, Cuenta cuentaAsociada) throws NumeroDeTarjetaInvalidaException {
		if (numero < 10_000_000 && numero > 99_999_999)
			throw new NumeroDeTarjetaInvalidaException("El numero de la tarjeta no coincide con el rango valido.");
		this.numero = numero;
		this.cuentaAsociada = cuentaAsociada;
		this.totalCompras = BigDecimal.ZERO;
	}

	public void comprar(BigDecimal monto) {
		if (monto.compareTo(BigDecimal.ZERO) <= 0)
			throw new IllegalArgumentException("El monto debe ser mayor que cero");
		totalCompras = totalCompras.add(monto);
	}

	public boolean debitarTotalCompras() {
		BigDecimal comision = totalCompras.multiply(new BigDecimal("0.03"));
		BigDecimal totalDebitar = totalCompras.add(comision);
		boolean pudeDebitar = cuentaAsociada.extraer(totalDebitar);
		if (pudeDebitar)
			totalCompras = BigDecimal.ZERO;
		return pudeDebitar;
	}

	public int getNumero() {
		return numero;
	}

	public BigDecimal getTotalCompras() {
		return totalCompras;
	}

}
