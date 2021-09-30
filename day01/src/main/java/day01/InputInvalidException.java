package day01;

public class InputInvalidException extends RuntimeException {

	private static final long serialVersionUID = -1972722481555743079L;

	public InputInvalidException() {
	}

	public InputInvalidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InputInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public InputInvalidException(String message) {
		super(message);
	}

	public InputInvalidException(Throwable cause) {
		super(cause);
	}

}
