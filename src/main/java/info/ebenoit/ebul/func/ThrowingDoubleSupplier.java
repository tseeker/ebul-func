package info.ebenoit.ebul.func;


import java.util.function.DoubleSupplier;



/**
 * This interface supports a {@link DoubleSupplier} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingDoubleSupplier
		extends DoubleSupplier
{

	/**
	 * Gets a result, or throws a {@link FunctionException} if an exception occurs.
	 *
	 * @return the result
	 * @throws FunctionException
	 *             if any exception occurs during the function's execution
	 */
	@Override
	default double getAsDouble( )
	{
		try {
			return this.throwingGetAsDouble( );
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
	public double throwingGetAsDouble( )
			throws Throwable;

}
