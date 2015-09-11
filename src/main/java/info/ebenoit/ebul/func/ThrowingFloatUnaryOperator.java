package info.ebenoit.ebul.func;


/**
 * This interface supports a {@link FloatUnaryOperator} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingFloatUnaryOperator
		extends FloatUnaryOperator
{

	/**
	 * Applies this function to the given argument.
	 *
	 * @param t
	 *            the first argument
	 * @return the result
	 * @throws FunctionException
	 *             if a checked exception occurs
	 */
	@Override
	default float applyAsFloat( final float t )
	{
		try {
			return this.throwingApplyAsFloat( t );
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
	 *            the first argument
	 * @return the result
	 * @throws Throwable
	 *             any exception
	 */
	public float throwingApplyAsFloat( float t )
			throws Throwable;

}
