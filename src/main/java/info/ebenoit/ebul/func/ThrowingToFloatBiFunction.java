package info.ebenoit.ebul.func;


/**
 * This interface supports a {@link ToFloatBiFunction} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingToFloatBiFunction< T , U >
		extends ToFloatBiFunction< T , U >
{

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first argument
	 * @param u
	 *            the second argument
	 * @return the result
	 * @throws FunctionException
	 *             if a checked exception occurs
	 */
	@Override
	default float applyAsFloat( final T t , final U u )
	{
		try {
			return this.throwingApplyAsFloat( t , u );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first argument
	 * @param u
	 *            the second argument
	 * @return the result
	 * @throws Throwable
	 *             any exception
	 */
	public float throwingApplyAsFloat( T t , U u )
			throws Throwable;

}
