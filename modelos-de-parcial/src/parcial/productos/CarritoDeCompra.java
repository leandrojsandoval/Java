package parcial.productos;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompra {

	private int id;
	private Usuario usuario;
	private List<Producto> productos;
	private List<Compra> compras;
	private double totalAPagar;

	public CarritoDeCompra(int id, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
		this.productos = new ArrayList<>();
		this.compras = new ArrayList<>();
		this.totalAPagar = 0;
	}

	public boolean agregarProducto(Producto producto) {
		if (producto == null)
			throw new NullPointerException();
		if (producto.getCantDisponible() == 0)
			return false;
		producto.setCantDisponible(producto.getCantDisponible() - 1);
		productos.add(producto);
		totalAPagar += producto.getPrecio();
		return true;
	}

	public void agregarCompra(Compra compra) {
		if (compra == null)
			throw new NullPointerException();
		compras.add(compra);
		totalAPagar += compra.getTotal();
	}

	public double calcularTotalDeCompra() {
		double totalProductos = 0;
		double totalCompras = 0;

		for (Producto producto : productos) {
			totalProductos += producto.getPrecio();
		}

		for (Compra compra : compras) {
			totalCompras += compra.getTotal();
		}

		return totalProductos + totalCompras;
	}

	public synchronized boolean realizarProcesoDePago() throws SaldoInvalidoException {
		return usuario.getCuenta().extraer(totalAPagar);
	}

	public int getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getTotalAPagar() {
		return totalAPagar;
	}
}
