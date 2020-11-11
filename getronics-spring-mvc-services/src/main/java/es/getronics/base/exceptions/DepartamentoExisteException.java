package es.getronics.base.exceptions;

public class DepartamentoExisteException extends Exception { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3047126920830719712L;

	public DepartamentoExisteException(String errmsg)
	{
		super(errmsg);
	}

}
