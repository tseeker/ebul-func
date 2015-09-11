package info.ebenoit.ebul.func;


import java.util.function.IntToLongFunction;



/**
 * This interface supports a {@link IntToLongFunction} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingIntToLongFunction
		extends IntToLongFunction
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
	default long applyAsLong( final int t )
	{
		try {
			return this.throwingApplyAsLong( t );
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
	public long throwingApplyAsLong( int t )
			throws Throwable;

}
