package info.ebenoit.ebul.func;


import java.util.function.DoubleUnaryOperator;



/**
 * This interface supports a {@link DoubleUnaryOperator} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingDoubleUnaryOperator
		extends DoubleUnaryOperator
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
	default double applyAsDouble( final double t )
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
	 *            the first argument
	 * @return the result
	 * @throws Throwable
	 *             any exception
	 */
	public double throwingApplyAsDouble( double t )
			throws Throwable;

}
