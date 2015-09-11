package info.ebenoit.ebul.func;


import java.util.function.BiPredicate;



/**
 * This interface supports a {@link BiPredicate} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingBiPredicate< T , U >
		extends BiPredicate< T , U >
{

	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @return <code>true</code> if the input arguments match the predicate, otherwise <code>false</code>
	 * @throws FunctionException
	 *             if a checked exception occurred during evaluation
	 */
	@Override
	default boolean test( final T t , final U u )
	{
		try {
			return this.throwingTest( t , u );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @return <code>true</code> if the input arguments match the predicate, otherwise <code>false</code>
	 * @throws Throwable
	 *             any checked exception
	 */
	public boolean throwingTest( T t , U u )
			throws Throwable;

}
