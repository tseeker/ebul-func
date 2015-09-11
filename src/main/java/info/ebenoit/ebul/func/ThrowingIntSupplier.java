package info.ebenoit.ebul.func;


import java.util.function.IntSupplier;



/**
 * This interface supports a {@link IntSupplier} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingIntSupplier
		extends IntSupplier
{

	/**
	 * Gets a result, or throws a {@link FunctionException} if an exception occurs.
	 *
	 * @return the result
	 * @throws FunctionException
	 *             if any exception occurs during the function's execution
	 */
	@Override
	default int getAsInt( )
	{
		try {
			return this.throwingGetAsInt( );
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
	public int throwingGetAsInt( )
			throws Throwable;

}
