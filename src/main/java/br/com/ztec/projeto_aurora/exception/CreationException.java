package br.com.ztec.projeto_aurora.exception;

public class CreationException extends RuntimeException {

  
	private static final long serialVersionUID = 1L;

	public CreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
