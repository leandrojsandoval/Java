package parcial.productos;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private static int contador = 1;
	private final int id;
	private final List<Producto> productos;
	private final double total;

	private static List<Producto> agregarProductos(Producto producto, int cantidad) {

		if (producto == null)
			throw new NullPointerException();

		List<Producto> productos = new ArrayList<>();

		for (int i = 0; i < cantidad; i++)
			productos.add(producto);

		producto.setCantDisponible(producto.getCantDisponible() - cantidad);

		return productos;
	}

	private double calcularTotalDeCompra() {
		double totalCompra = 0;
		for (Producto producto : productos) {
			totalCompra += producto.getPrecio();
		}
		return totalCompra;
	}

	public Compra(Producto producto, int cantidad) {
		if (cantidad < 0)
			throw new CantidadInvalidaException("La cantidad ingresada es incorrecta");
		if (cantidad > producto.getCantDisponible())
			throw new CantidadInvalidaException("La cantidad de la compra supera a la cantidad disponible");
		this.id = contador++;
		this.productos = agregarProductos(producto, cantidad);
		this.total = calcularTotalDeCompra();
	}

	public int getId() {
		return id;
	}

	public double getTotal() {
		return total;
	}

}
