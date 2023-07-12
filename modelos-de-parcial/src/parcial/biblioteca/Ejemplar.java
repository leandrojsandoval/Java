package parcial.biblioteca;

public class Ejemplar {

	private int id;
	private Libro libro;
	private EstadoEjemplar estado;

	public Ejemplar(int id, Libro libro) {
		this.id = id;
		this.libro = libro;
		this.estado = new EstadoDisponible();
	}

	public void cambiarEstado(EstadoEjemplar nuevoEstado) {
		this.estado = nuevoEstado;
	}

	public EstadoEjemplar getEstado() {
		return estado;
	}

	public void prestar() {
		estado.prestarEjemplar(this);
	}

	public void devolver() {
		estado.devolverEjemplar(this);
	}

	public int getId() {
		return id;
	}

	public Libro getLibro() {
		return libro;
	}

	@Override
	public String toString() {
		return "Ejemplar: " + id + "\n" + libro;
	}

}
