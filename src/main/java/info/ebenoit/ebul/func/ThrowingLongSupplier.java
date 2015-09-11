package info.ebenoit.ebul.func;


import java.util.function.LongSupplier;



/**
 * This interface supports a {@link LongSupplier} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingLongSupplier
		extends LongSupplier
{

	/**
	 * Gets a result, or throws a {@link FunctionException} if an exception occurs.
	 *
	 * @return the result
	 * @throws FunctionException
	 *             if any exception occurs during the function's execution
	 */
	@Override
	default long getAsLong( )
	{
		try {
			return this.throwingGetAsLong( );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Gets a result or throws an exception
	 *
	 * @return the result
	 * @throws Throwable
	 *             any exception
	 */
	public long throwingGetAsLong( )
			throws Throwable;

}
