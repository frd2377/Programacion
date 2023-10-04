package ejemplo2_ArrayList;

import java.util.Scanner;

public class Estudiante {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Boolean salir = true;
		while (salir) {
			String opcion = input.next();
			switch (opcion) {
				case "r":
					break;
				case "l":
					break;
				case "e":
					break;
				case "x":
					input.close();
					break;
				default:
					break;
			}
		}
	}

    String nombre;
    long cedula;
    double nota;
    
    Estudiante(String nombre,long cedula,double nota){
        this.nombre = nombre;
        this.cedula = cedula;
        this.nota = nota;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Long getCedula(){
        return this.cedula;
    }

    public Double getNota(){
        return this.nota;
    }

    public void getEstado(){
        if (this.nota >= 70) {
            
        }else if (this.nota < 70) {
            
        }else{

        }
    }
    
}