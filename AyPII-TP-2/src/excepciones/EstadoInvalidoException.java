package excepciones;

public class EstadoInvalidoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -878665292545156144L;
	
	public EstadoInvalidoException(String mensaje){
		super(mensaje);
	}
	
	public EstadoInvalidoException(){
		super("El Estado de la Mesa no es válido");
	}
	

}