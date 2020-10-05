/**
 * 
 */
package es.getronics.base.dao.exception;

/**
 * Excepcion lanzada por el dao
 * @author jgarcia
 *
 */
public class GetronicsDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1787283214835165307L;

	public GetronicsDaoException() {
		super();
	}

	public GetronicsDaoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GetronicsDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public GetronicsDaoException(String message) {
		super(message);
	}

	public GetronicsDaoException(Throwable cause) {
		super(cause);
	}

}
