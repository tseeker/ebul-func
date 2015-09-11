package info.ebenoit.ebul.func;


/**
 * Represents a function that accepts two arguments and produces a {@code float}-valued result. This is the
 * {@code float}-producing primitive specialisation for {@link java.util.function.BiFunction}.
 *
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is
 * {@link #applyAsFloat(Object, Object)}.
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 *
 * @see java.util.function.BiFunction
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface ToFloatBiFunction< T , U >
{

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param u
	 *            the second function argument
	 * @return the function result
	 */
	public float applyAsFloat( T t , U u );
}
