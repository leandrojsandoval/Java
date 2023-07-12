package parcial.biblioteca;

import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Prestamo {

	private final int codigo;
	private final Usuario usuario;
	private List<Ejemplar> ejemplares;
	private final LocalDate fechaRealizacion;
	private LocalDate fechaDevolucion;
	private static final double PRECIO_MULTA_POR_DIA = 500;
	private static final int CODIGO_PEDIDO_MAXIMO = 10000;

	private static int generarCodigo() {
		Random random = new Random();
		return random.nextInt(CODIGO_PEDIDO_MAXIMO) + 1;
	}

	public Prestamo(Usuario usuario, LocalDate fechaDevolucion) throws FechaInvalidaException {
		if (LocalDate.now().isAfter(fechaDevolucion))
			throw new FechaInvalidaException("No es posible declarar una fecha anterior a la actual");
		this.codigo = generarCodigo();
		this.usuario = usuario;
		this.ejemplares = new LinkedList<>();
		this.fechaRealizacion = LocalDate.now();
		this.fechaDevolucion = fechaDevolucion;
	}

	public boolean agregarEjemplar(Ejemplar ejemplar) {
		if (ejemplar == null)
			throw new NullPointerException();

		if (ejemplar.getEstado() instanceof EstadoPrestado) {
			return false;
		}

		ejemplares.add(ejemplar);
		ejemplar.cambiarEstado(new EstadoPrestado());
		return true;
	}

	public double obtenerMultaPorVencimiento() {
		long diasDeRetraso = ChronoUnit.DAYS.between(fechaDevolucion, LocalDate.now());
		return diasDeRetraso > 0 ? diasDeRetraso * PRECIO_MULTA_POR_DIA : 0;
	}

	public synchronized boolean procesarPedido(Prestamo prestamo) {
		double multa = prestamo.obtenerMultaPorVencimiento();
		double saldoUsuario = prestamo.getUsuario().getSaldo();
		if (saldoUsuario < multa)
			throw new SaldoInsuficienteException("No es posible pagar la multa");
		prestamo.getUsuario().setSaldo(saldoUsuario - multa);
		for (Ejemplar ejemplar : ejemplares)
			ejemplar.cambiarEstado(new EstadoDisponible());
		return true;
	}

	public int getCodigo() {
		return codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public LocalDate getFechaRealizacion() {
		return fechaRealizacion;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

}