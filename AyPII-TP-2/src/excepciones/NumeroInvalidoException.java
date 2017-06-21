package excepciones;

public class NumeroInvalidoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -163995313794786489L;
	
	public NumeroInvalidoException(String mensaje){
		super(mensaje);
	}
	
	public NumeroInvalidoException(){
		super("El número ingresado no es válido");
	}
	
	

}