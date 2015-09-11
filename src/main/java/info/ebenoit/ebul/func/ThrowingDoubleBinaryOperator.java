package info.ebenoit.ebul.func;


import java.util.function.DoubleBinaryOperator;



/**
 * This interface supports a {@link DoubleBinaryOperator} that can throw checked exceptions. Checked exceptions are
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingDoubleBinaryOperator
		extends DoubleBinaryOperator
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
	default double applyAsDouble( final double t , final double u )
	{
		try {
			return this.throwingApplyAsDouble( t , u );
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
	public double throwingApplyAsDouble( double t , double u )
			throws Throwable;

}
