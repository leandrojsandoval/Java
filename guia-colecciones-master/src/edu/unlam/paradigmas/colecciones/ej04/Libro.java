package edu.unlam.paradigmas.colecciones.ej04;

import java.util.Objects;

public class Libro implements Comparable<Libro>{

	private String titulo;
	private String autor;

	public Libro(String titulo, String autor) {
		if (titulo == null || autor == null)
			throw new NullPointerException("Los valores no pueden ser nulos");
		this.titulo = titulo;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return String.format("%-50s", "Titulo: " + titulo) + String.format("%-20s", "Autor: " + autor);
	}
	
	@Override
	public int compareTo(Libro otro) {
		int comp = this.titulo.compareTo(otro.titulo);
		if(comp == 0)
			return this.autor.compareTo(otro.autor);
		return comp;
	}

}
