package info.ebenoit.ebul.func;


/**
 * This interface supports a {@link Runnable} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingRunnable
		extends Runnable
{

	/**
	 * Executes the procedure
	 *
	 * @throws FunctionException
	 *             if a checked exception occurs
	 */
	@Override
	default void run( )
	{
		try {
			this.throwingRun( );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Executes the procedure, may throw any exception
	 *
	 * @throws Throwable
	 *             any exception
	 */
	public void throwingRun( )
			throws Throwable;
}
