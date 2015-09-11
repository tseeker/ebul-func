package info.ebenoit.ebul.func;


/**
 * This interface supports a {@link FloatToDoubleFunction} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingFloatToDoubleFunction
		extends FloatToDoubleFunction
{

	/**
	 * Applies this function to the given argument.
	 *
	 * @param t
	 *            the argument
	 * @return the result
	 * @throws FunctionException
	 *             if a checked exception occurs
	 */
	@Override
	default double applyAsDouble( final float t )
	{
		try {
			return this.throwingApplyAsDouble( t );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Applies this function to the given argument.
	 *
	 * @param t
	 *            the argument
	 * @return the result
	 * @throws Throwable
	 *             if a checked exception occurs
	 */
	public double throwingApplyAsDouble( float t )
			throws Throwable;

}
