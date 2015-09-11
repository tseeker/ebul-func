package info.ebenoit.ebul.func;


import java.util.function.Predicate;



/**
 * This interface supports a {@link Predicate} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingPredicate< T >
		extends Predicate< T >
{

	/**
	 * Evaluates this predicate on the given argument.
	 *
	 * @param t
	 *            the argument
	 * @return <code>true</code> if the input argument matches the predicate, otherwise <code>false</code>
	 * @throws FunctionException
	 *             if a checked exception occurs
	 */
	@Override
	default boolean test( final T t )
	{
		try {
			return this.throwingTest( t );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Evaluates this predicate on the given argument.
	 *
	 * @param t
	 *            the argument
	 * @return <code>true</code> if the input argument matches the predicate, otherwise <code>false</code>
	 * @throws Throwable
	 *             any exception
	 */
	public boolean throwingTest( T t )
			throws Throwable;

}
