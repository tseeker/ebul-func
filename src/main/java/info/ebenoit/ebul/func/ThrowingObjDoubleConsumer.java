package info.ebenoit.ebul.func;


import java.util.function.ObjDoubleConsumer;



/**
 * This interface supports a {@link ObjDoubleConsumer} that can throw checked exceptions. Checked exceptions are then
 * transmitted using a {@link FunctionException} runtime exception.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ThrowingObjDoubleConsumer< T >
		extends ObjDoubleConsumer< T >
{

	/**
	 * Performs the operation on the given arguments, or throws a {@link FunctionException} if a checked exception
	 * occurs.
	 *
	 * @param t
	 *            the first argument
	 * @param u
	 *            the second argument
	 * @throws FunctionException
	 *             if any checked exception occurs during the function's execution
	 */
	@Override
	default void accept( final T t , final double u )
	{
		try {
			this.throwingAccept( t , u );
		} catch ( final RuntimeException e ) {
			throw e;
		} catch ( final Throwable e ) {
			throw new FunctionException( e );
		}
	}


	/**
	 * Performs the operation on the given arguments, or throws an arbitrary exception
	 *
	 * @param t
	 *            the first argument
	 * @param u
	 *            the second argument
	 * @throws Throwable
	 *             any exception
	 */
	public void throwingAccept( T t , double u )
			throws Throwable;

}
