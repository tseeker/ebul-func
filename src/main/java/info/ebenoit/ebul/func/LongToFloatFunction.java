package info.ebenoit.ebul.func;


/**
 * Represents a function that accepts a {@code long}-valued argument and produces a {@code float}-valued result. This is
 * the {@code long}-to-{@code float} primitive specialisation for {@link java.util.function.Function}.
 *
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is {@link #applyAsFloat(long)}.
 *
 * @see java.util.function.Function
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface LongToFloatFunction
{

	/**
	 * Applies this function to the given argument.
	 *
	 * @param value
	 *            the function argument
	 * @return the function result
	 */
	public float applyAsFloat( long value );
}
