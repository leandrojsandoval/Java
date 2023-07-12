package edu.unlam.paradigmas.entradasalida.ej03;

public class Resolucion {

	public void resolucionDeGanadores(String nombreArchivo) {

		Archivo archivo = new Archivo(nombreArchivo);
		Sumo[] datosLectura = archivo.leerArchivoSumos();

		int[] datosEscritura = new int[datosLectura.length];

		for (int i = 0; i < datosLectura.length; i++) {
			int cantVecesGanador = 0;
			for (int j = 0; j < datosLectura.length; j++)
				if (i != j)
					if (esDominante(datosLectura[i], datosLectura[j]))
						cantVecesGanador++;
			datosEscritura[i] = cantVecesGanador;
		}

		archivo.grabarArchivo(datosEscritura);
	}

	public boolean esDominante(Sumo sumoParticipante, Sumo sumoContrincante) {
		return (sumoParticipante.getPeso() > sumoContrincante.getPeso()
				&& sumoParticipante.getAltura() > sumoContrincante.getAltura())
				|| (sumoParticipante.getPeso() == sumoContrincante.getPeso()
						&& sumoParticipante.getAltura() > sumoContrincante.getAltura())
				|| (sumoParticipante.getPeso() > sumoContrincante.getPeso()
						&& sumoParticipante.getAltura() == sumoContrincante.getAltura());
	}
}
