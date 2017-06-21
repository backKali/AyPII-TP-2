package excepciones;

public class FechaInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4663564782518144563L;

	public FechaInvalidaException(String mensaje) {
		super(mensaje);
	}
	
	public FechaInvalidaException(){
		super("La fecha ingresada no es válida");
	}

}