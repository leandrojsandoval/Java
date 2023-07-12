package parcial.productos;

public class Usuario {

	private int id;
	private String nombre;
	private String apellido;
	private Cuenta cuenta;

	public Usuario(int id, String nombre, String apellido, Cuenta cuenta) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuenta = cuenta;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}
}
