package parcial.biblioteca;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		// Categorías
		Categoria novela = new Categoria(1, "Novela");
		Categoria cienciaFiccion = new Categoria(2, "Ciencia ficcion");

		// Autores
		Autor gabrielGarciaMarquez = new Autor(1, "Gabriel", "Garcia Marquez", LocalDate.of(1927, 3, 6));
		Autor jKRowling = new Autor(2, "J.K.", "Rowling", LocalDate.of(1965, 7, 31));
		Autor stephenKing = new Autor(3, "Stephen", "King", LocalDate.of(1947, 9, 21));

		// Libros
		Libro cienAniosDeSoledad1 = new Libro(9780307476463L, "Cien anios de soledad", novela,
				Arrays.asList(gabrielGarciaMarquez), LocalDate.of(1967, 5, 30), 432);
		Libro harryPotterYLaPiedraFilosofal = new Libro(9788478888566L, "Harry Potter y la piedra filosofal",
				cienciaFiccion, Arrays.asList(jKRowling), LocalDate.of(1997, 6, 26), 256);
		Libro elResplandor = new Libro(9788497593793L, "El resplandor", cienciaFiccion, Arrays.asList(stephenKing),
				LocalDate.of(1977, 1, 28), 512);
		Libro cienAniosDeSoledad2 = new Libro(9788401352347L, "Cien anios de soledad", novela,
				Arrays.asList(gabrielGarciaMarquez), LocalDate.of(1969, 9, 1), 416);

		// Ejemplares
		Ejemplar ejemplar1 = new Ejemplar(1, cienAniosDeSoledad1);
		Ejemplar ejemplar2 = new Ejemplar(2, cienAniosDeSoledad1);
		Ejemplar ejemplar3 = new Ejemplar(3, harryPotterYLaPiedraFilosofal);
		Ejemplar ejemplar4 = new Ejemplar(4, elResplandor);
		Ejemplar ejemplar5 = new Ejemplar(5, cienAniosDeSoledad2);
		Ejemplar ejemplar6 = new Ejemplar(6, cienAniosDeSoledad2);

		// Usuarios
		Usuario johnDoe = new Usuario(1, "John Doe", novela, 100000);

		LocalDate fechaDevolucion1 = LocalDate.of(2023, 7, 31);

		Prestamo pedido1;

		try {
			pedido1 = new Prestamo(johnDoe, fechaDevolucion1);

			pedido1.agregarEjemplar(ejemplar1);
			pedido1.agregarEjemplar(ejemplar2);
			pedido1.agregarEjemplar(ejemplar3);
			pedido1.agregarEjemplar(ejemplar4);
			pedido1.agregarEjemplar(ejemplar5);
			pedido1.agregarEjemplar(ejemplar6);

			System.out.println(johnDoe.toString() + "\n");
			johnDoe.consultarEjemplar(ejemplar1);
			ejemplar1.prestar();
			System.out.println();
			pedido1.procesarPedido(pedido1);
			System.out.println(johnDoe.toString() + "\n");
			ejemplar1.prestar();

		} catch (FechaInvalidaException | SaldoInsuficienteException e) {
			e.printStackTrace();
		}
	}
}
