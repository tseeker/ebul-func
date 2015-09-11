package info.ebenoit.ebul.func;


import java.util.function.BiFunction;



/**
 * This interface supports a {@link BiFunction} that can throw checked exceptions. Checked exceptions are transmitted
 * using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingBiFunction< T , U , R >
		extends BiFunction< T , U , R >
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
	default R apply( final T t , final U u )
	{
		try {
			return this.throwingApply( t , u );
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
	public R throwingApply( T t , U u )
			throws Throwable;

}
