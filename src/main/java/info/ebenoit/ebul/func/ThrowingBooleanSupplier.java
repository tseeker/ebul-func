package info.ebenoit.ebul.func;


import java.util.function.BooleanSupplier;



/**
 * This interface supports a {@link BooleanSupplier} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingBooleanSupplier
		extends BooleanSupplier
{

	/**
	 * Gets a result
	 *
	 * @return a result
	 * @throws FunctionException
	 *             if a checked exception occurred
	 */
	@Override
	default boolean getAsBoolean( )
	{
		try {
			return this.throwingGetAsBoolean( );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Gets a result
	 *
	 * @return a result
	 * @throws Throwable
	 *             any exception
	 */
	public boolean throwingGetAsBoolean( )
			throws Throwable;

}
