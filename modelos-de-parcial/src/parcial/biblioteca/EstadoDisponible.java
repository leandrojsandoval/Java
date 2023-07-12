package parcial.biblioteca;

public class EstadoDisponible implements EstadoEjemplar {

	@Override
	public void prestarEjemplar(Ejemplar ejemplar) {
		System.out.println("El ejemplar " + ejemplar.getLibro().getNombre() + " esta disponible para ser prestado.");
	}

	@Override
	public void devolverEjemplar(Ejemplar ejemplar) {
		System.out.println("El ejemplar " + ejemplar.getLibro().getNombre()
				+ " no puede ser devuelto, ya que no ha sido prestado.");
	}

}
