package info.ebenoit.ebul.func;


import java.util.function.IntConsumer;



/**
 * This interface supports a {@link IntConsumer} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingIntConsumer
		extends IntConsumer
{

	/**
	 * Performs the operation on the given argument.
	 *
	 * @param t
	 *            the input argument
	 * @throws FunctionException
	 *             if a checked exception occurs during the operation's execution
	 */
	@Override
	default void accept( final int t )
	{
		try {
			this.throwingAccept( t );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Performs the operation on the given argument.
	 *
	 * @param t
	 *            the input argument
	 * @throws Throwable
	 *             any exception
	 */
	public void throwingAccept( int t )
			throws Throwable;

}
