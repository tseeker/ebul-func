package info.ebenoit.ebul.func;


import java.util.function.IntUnaryOperator;



/**
 * This interface supports a {@link IntUnaryOperator} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingIntUnaryOperator
		extends IntUnaryOperator
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
	default int applyAsInt( final int t )
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
	 *            the first argument
	 * @return the result
	 * @throws Throwable
	 *             any exception
	 */
	public int throwingApplyAsInt( int t )
			throws Throwable;

}
