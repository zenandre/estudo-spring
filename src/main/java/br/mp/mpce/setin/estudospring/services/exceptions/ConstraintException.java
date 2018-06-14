package br.mp.mpce.setin.estudospring.services.exceptions;

public class ConstraintException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ConstraintException(String msg) {
		super(msg);
	}
	
	public ConstraintException(String msg,Throwable exception) {
		super(msg,exception);
	}
}
