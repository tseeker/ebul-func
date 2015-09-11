package info.ebenoit.ebul.func;


/**
 * Represents a function that accepts a {@code float}-valued argument and produces a (@code double}-valued result. This
 * is the {@code float}-to-{@code double} primitive specialisation for {@link java.util.function.Function}.
 *
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is {@link #applyAsDouble(float)}.
 *
 * @see java.util.function.Function
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface FloatToDoubleFunction
{

	/**
	 * Applies this function to the given argument.
	 *
	 * @param value
	 *            the function argument
	 * @return the function result
	 */
	public double applyAsDouble( float value );
}
