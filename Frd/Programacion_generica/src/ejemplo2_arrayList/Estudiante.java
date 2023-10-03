package ejemplo2_arrayList;

public class Estudiante {

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