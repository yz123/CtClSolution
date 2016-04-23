package Chapter3;

public class StackEmptyException extends Exception {
	private static final long serialVersionUID = 1L;

	public StackEmptyException(){
        super();
    }

    public StackEmptyException(String message){
        super(message);
    }

}
