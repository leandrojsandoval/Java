package parcial.campus;

public class Calificacion {

	private Estudiante estudiante;
	private Asignatura asignatura;
	private int notaPrimerParcial;
	private int notaSegundoParcial;
	private EstadoCalificacion estado;

	public Calificacion(Estudiante estudiante, Asignatura asignatura) {
		this.estudiante = estudiante;
		this.asignatura = asignatura;
		this.notaPrimerParcial = 0;
		this.notaSegundoParcial = 0;
		this.estado = new CalificacionPendiente();
	}

	public void cambiarDeEstado(EstadoCalificacion nuevoEstado) {
		if (nuevoEstado != null)
			this.estado = nuevoEstado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public int getNotaPrimerParcial() {
		return notaPrimerParcial;
	}

	public int getNotaSegundoParcial() {
		return notaSegundoParcial;
	}

	public EstadoCalificacion getEstado() {
		return estado;
	}

	public void setNotaPrimerParcial(int notaPrimerParcial) {
		this.notaPrimerParcial = notaPrimerParcial;
	}

	public void setNotaSegundoParcial(int notaSegundoParcial) {
		this.notaSegundoParcial = notaSegundoParcial;
	}

	@Override
	public String toString() {
		return "Calificacion\n" + estudiante + ", Asignatura: " + asignatura + "\nNota primer parcial: "
				+ notaPrimerParcial + ", Nota segundo parcial: " + notaSegundoParcial;
	}

}
