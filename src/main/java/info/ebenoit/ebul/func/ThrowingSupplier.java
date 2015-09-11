package info.ebenoit.ebul.func;


import java.util.function.Supplier;



/**
 * This interface supports a {@link Supplier} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingSupplier< T >
		extends Supplier< T >
{

	/**
	 * Gets a result, or throws a {@link FunctionException} if an exception occurs.
	 *
	 * @return the result
	 * @throws FunctionException
	 *             if any exception occurs during the function's execution
	 */
	@Override
	default T get( )
	{
		try {
			return this.throwingGet( );
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
	public T throwingGet( )
			throws Throwable;

}
