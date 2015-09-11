package info.ebenoit.ebul.func;


import java.util.function.LongToIntFunction;



/**
 * This interface supports a {@link LongToIntFunction} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingLongToIntFunction
		extends LongToIntFunction
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
	default int applyAsInt( final long t )
	{
		try {
			return this.throwingApplyAsInt( t );
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
	public int throwingApplyAsInt( long t )
			throws Throwable;

}
