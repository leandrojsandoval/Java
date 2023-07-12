package parcial.cocina;

import java.time.LocalDate;

public class Cocinero extends Empleado {

	public Cocinero(int dni, LocalDate fechaIngreso) {
		super(dni, fechaIngreso);
	}

	@Override
	public void realizarTarea() {
		armarPlato();
		super.realizarTarea();
	}

	private void armarPlato() {
		System.out.println("Cocinero: Preparando plato");
	}

}
