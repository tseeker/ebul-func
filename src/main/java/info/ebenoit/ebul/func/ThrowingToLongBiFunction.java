package info.ebenoit.ebul.func;


import java.util.function.ToLongBiFunction;



/**
 * This interface supports a {@link ToLongBiFunction} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingToLongBiFunction< T , U >
		extends ToLongBiFunction< T , U >
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
	default long applyAsLong( final T t , final U u )
	{
		try {
			return this.throwingApplyAsLong( t , u );
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
	public long throwingApplyAsLong( T t , U u )
			throws Throwable;

}
