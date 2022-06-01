package exception;

public class IdNotFindException extends Exception{
	
	public IdNotFindException() {
		super("Id não encontrado");
	}
	
	public IdNotFindException(String msg) {
		super(msg);
	}
}
