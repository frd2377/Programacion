package ejemplo3_arraylist;

/**
 * ejemplo3
 */
public class Generica <T>{

    public T atributoUno;
    private T atributoDos;
    
    
    public Generica(){
        super();
    }

    public Generica(T atributoUno){
        super();
        this.atributoUno = atributoUno;
    }

    public Generica(T atributoUno,T atributoDos){
        super();
        this.atributoUno = atributoUno;
        this.setAtributoDos(atributoDos);
    }

	public T getAtributoDos() {
		return atributoDos;
	}

	public void setAtributoDos(T atributoDos) {
		this.atributoDos = atributoDos;
	}

    
}
