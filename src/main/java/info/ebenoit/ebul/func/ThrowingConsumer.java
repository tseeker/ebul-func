package info.ebenoit.ebul.func;


import java.util.function.Consumer;



/**
 * This interface supports a {@link Consumer} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingConsumer< T >
		extends Consumer< T >
{

	/**
	 * Performs the operation on the given argument, or throws a {@link FunctionException} if a checked exception
	 * occurs.
	 *
	 * @param t
	 *            the input argument
	 * @throws FunctionException
	 *             if any exception occurs during the function's execution
	 */
	@Override
	default void accept( final T t )
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
	 * Performs the operation on the given argument, or throws an exception.
	 *
	 * @param t
	 *            the input argument
	 * @throws Throwable
	 *             any exception
	 */
	public void throwingAccept( T t )
			throws Throwable;

}
