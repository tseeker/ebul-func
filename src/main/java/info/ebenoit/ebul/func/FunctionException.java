package info.ebenoit.ebul.func;


/**
 * Runtime exception thrown by Throwing* functional interfaces. Carries the cause of the problem.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
public class FunctionException
		extends RuntimeException
{

	private static final long serialVersionUID = -2690556374343638022L;


	/**
	 * Initialises the exception from a cause
	 *
	 * @param cause
	 *            the exception that happened while the function was being executed.
	 */
	public FunctionException( final Throwable cause )
	{
		super( "checked exception in function" , cause );
	}

}
