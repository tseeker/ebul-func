package info.ebenoit.ebul.func;


/**
 * Represents a function that accepts a {@code float}-valued argument and produces a result. This is the {@code float}
 * -consuming primitive specialisation for {@link java.util.function.Function}.
 *
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is {@link #apply(float)}.
 *
 * @param <R>
 *            the type of the result of the function
 *
 * @see java.util.function.Function
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface FloatFunction< R >
{

	/**
	 * Applies this function to the given argument.
	 *
	 * @param value
	 *            the function argument
	 * @return the function result
	 */
	public R apply( float value );
}
