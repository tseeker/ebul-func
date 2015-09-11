package info.ebenoit.ebul.func;


/**
 * Represents an operation that accepts an object-valued and a {@code float}-valued argument, and returns no result.
 * This is the {@code (reference, float)} specialisation of {@link java.util.function.BiConsumer}. Unlike most other
 * functional interfaces, {@code ObjDoubleConsumer} is expected to operate via side-effects.
 *
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is {@link #accept(Object, float)}.
 *
 * @param <T>
 *            the type of the object argument to the operation
 *
 * @see java.util.function.BiConsumer
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ObjFloatConsumer< T >
{

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param value
	 *            the second input argument
	 */
	public void accept( T t , float value );
}
