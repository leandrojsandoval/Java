package parcial.biblioteca;

public class EstadoPrestado implements EstadoEjemplar {

	@Override
	public void prestarEjemplar(Ejemplar ejemplar) {
		System.out.println(
				"El ejemplar " + ejemplar.getLibro().getNombre() + " no puede ser prestado, ya que esta en prestamo.");
	}

	@Override
	public void devolverEjemplar(Ejemplar ejemplar) {
		System.out.println(
				"El ejemplar " + ejemplar.getLibro().getNombre() + " se encuentra en la biblioteca y esta disponible");
	}

}
