package info.ebenoit.ebul.func;


import java.util.function.LongUnaryOperator;



/**
 * This interface supports a {@link LongUnaryOperator} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingLongUnaryOperator
		extends LongUnaryOperator
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
	default long applyAsLong( final long t )
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
	 *            the first argument
	 * @return the result
	 * @throws Throwable
	 *             any exception
	 */
	public long throwingApplyAsLong( long t )
			throws Throwable;

}
