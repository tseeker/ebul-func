package info.ebenoit.ebul.func;


import java.util.function.DoubleConsumer;



/**
 * This interface supports a {@link DoubleConsumer} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingDoubleConsumer
		extends DoubleConsumer
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
	default void accept( final double t )
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
	public void throwingAccept( double t )
			throws Throwable;

}
