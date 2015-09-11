package info.ebenoit.ebul.func;


/**
 * This interface supports a {@link FloatSupplier} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingFloatSupplier
		extends FloatSupplier
{

	/**
	 * Gets a result, or throws a {@link FunctionException} if an exception occurs.
	 *
	 * @return the result
	 * @throws FunctionException
	 *             if any exception occurs during the function's execution
	 */
	@Override
	default float getAsFloat( )
	{
		try {
			return this.throwingGetAsFloat( );
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
	public float throwingGetAsFloat( )
			throws Throwable;

}
