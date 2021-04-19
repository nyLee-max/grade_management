package grade_management.ui.exception;

public class SqlConstraintException extends RuntimeException {

	public SqlConstraintException() {
		super("참조하는 레코드가 존재합니다.");
	}


	public SqlConstraintException(String message, Throwable cause) {
		super("참조하는 레코드가 존재합니다.", cause);
	}

	public SqlConstraintException(String message) {
		super(message);
	}

	public SqlConstraintException(Throwable cause) {
		super(cause);
	}
	
}
