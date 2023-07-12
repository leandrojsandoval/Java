package edu.unlam.paradigmas.herencia.ej01;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

	@Test
	public void nuevaCuenta() {
		Cuenta cuenta = new Cuenta();
		BigDecimal resultadoObtenido = cuenta.consultarSaldo();
		BigDecimal resultadoEsperado = BigDecimal.ZERO;
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void depositoEnCuenta() {
		Cuenta cuenta = new Cuenta();
		cuenta.depositar(new BigDecimal("10000"));
		BigDecimal resultadoObtenido = cuenta.consultarSaldo();
		BigDecimal resultadoEsperado = new BigDecimal("10000");
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}

	public void depositoEnCuentaNuevativo() {
		Cuenta cuenta = new Cuenta();
		Assert.assertFalse(cuenta.depositar(new BigDecimal("-10000")));
	}

	@Test
	public void extraccionEnCuenta() {
		Cuenta cuenta = new Cuenta();
		cuenta.depositar(new BigDecimal("10000"));
		cuenta.extraer(new BigDecimal("5000"));
		BigDecimal resultadoObtenido = cuenta.consultarSaldo();
		BigDecimal resultadoEsperado = new BigDecimal("5000");
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void extraccionConMontoNegativo() {
		Cuenta cuenta = new Cuenta();
		cuenta.depositar(new BigDecimal("10000"));
		Assert.assertFalse(cuenta.extraer(new BigDecimal("-5000")));
	}

	@Test
	public void extraccionConMontoMayorAlSaldoDeLaCuenta() {
		Cuenta cuenta = new Cuenta();
		cuenta.depositar(new BigDecimal("10000"));
		Assert.assertFalse(cuenta.extraer(new BigDecimal("20000")));
	}

	@Test
	public void transaccionEntreCuentas() {
		Cuenta cuentaOrigen = new Cuenta();
		cuentaOrigen.depositar(new BigDecimal("10000"));

		Cuenta cuentaDestino = new Cuenta();
		cuentaOrigen.transferir(new BigDecimal("550.0"), cuentaDestino);

		BigDecimal resultadoObtenido = cuentaOrigen.consultarSaldo();
		BigDecimal resultadoEsperado = new BigDecimal("9450");

		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}

}