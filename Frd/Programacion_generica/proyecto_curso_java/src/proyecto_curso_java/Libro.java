package proyecto_curso_java;

public class Libro {
	int isbn;
	String autor;
	String titulo;
	int año;
	String disponible;

	Libro(int isbn,String autor, String titulo, int año){
		this.isbn = isbn;
		this.autor = autor;
		this.titulo = titulo;
		this.año = año;
		this.disponible = "DISPONIBLE";
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	
	@Override
	public String toString() {
		return this.autor+", "+this.titulo+", "+this.año+", "+this.isbn+", "+this.disponible;
	}

}
