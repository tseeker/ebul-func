package info.ebenoit.ebul.func;


/**
 * Represents a function that produces a {@code float}-valued result. This is the {@code float}-producing primitive
 * specialisation for {@link java.util.function.Function}.
 *
 * This is a {@link java.util.function functional interface} whose functional method is {@link #applyAsFloat(Object)}.
 *
 * @param <T>
 *            the type of the input to the function
 *
 * @see java.util.function.Function
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ToFloatFunction< T >
{

	/**
	 * Applies this function to the given argument.
	 *
	 * @param value
	 *            the function argument
	 * @return the function result
	 */
	public float applyAsFloat( T value );
}
