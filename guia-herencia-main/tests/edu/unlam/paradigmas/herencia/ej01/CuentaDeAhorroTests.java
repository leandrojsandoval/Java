package edu.unlam.paradigmas.herencia.ej01;

import org.junit.Test;

import java.math.BigDecimal;

import org.junit.Assert;

public class CuentaDeAhorroTests {

	@Test
	public void seReservoSaldo() {
		CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro();
		cuentaDeAhorro.depositar(new BigDecimal("5000"));
		cuentaDeAhorro.reservarSaldo(new BigDecimal("2500"));
		BigDecimal resultadoObtenido = cuentaDeAhorro.consultarSaldo();
		BigDecimal resultadoEsperado = new BigDecimal("2500");
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void seQuiereReservarConMasDeLoQueHay() {
		CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro();
		cuentaDeAhorro.depositar(new BigDecimal("5000"));
		Assert.assertFalse(cuentaDeAhorro.reservarSaldo(new BigDecimal("7500")));
	}

	@Test
	public void seReintegroSaldo() {
		CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro();
		cuentaDeAhorro.depositar(new BigDecimal("5000"));
		cuentaDeAhorro.reservarSaldo(new BigDecimal("2500"));
		cuentaDeAhorro.reintegrarSaldoReservado();
		BigDecimal resultadoObtenido = cuentaDeAhorro.consultarSaldo();
		BigDecimal resultadoEsperado = new BigDecimal("5000");
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}
}
