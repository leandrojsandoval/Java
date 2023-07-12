package edu.unlam.paradigmas.entradasalida.ej03;

import edu.unlam.paradigmas.entradasalida.constantes.Constante;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	private String nombreArchivo;

	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Sumo[] leerArchivoSumos() {

		Scanner scanner = null;
		Sumo[] sumos = null;

		try {

			scanner = new Scanner(
					new File(Constante.DIRECCION_ARCHIVOS_IN + this.nombreArchivo + Constante.EXTENSION_IN));
			scanner.useLocale(Locale.ENGLISH);

			sumos = new Sumo[scanner.nextInt()];

			for (int i = 0; i < sumos.length; i++) {
				int peso = scanner.nextInt();
				int altura = scanner.nextInt();
				sumos[i] = new Sumo(peso, altura);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return sumos;
	}

	public void grabarArchivo(int[] datos) {

		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {

			fileWriter = new FileWriter(
					Constante.DIRECCION_ARCHIVOS_OUT + this.nombreArchivo + Constante.EXTENSION_OUT);
			printWriter = new PrintWriter(fileWriter);

			for (int i = 0; i < datos.length; i++)
				printWriter.print(datos[i] + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null)
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
}
