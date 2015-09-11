package info.ebenoit.ebul.func;


import java.util.Objects;



/**
 * Represents an operation that accepts a single {@code float}-valued argument and returns no result. This is the
 * primitive type specialisation of {@link java.util.function.Consumer} for {@code float}. Unlike most other functional
 * interfaces, {@code FloatConsumer} is expected to operate via side-effects.
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is {@link #accept(float)}.
 *
 * @see java.util.function.Consumer
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface FloatConsumer
{
	/**
	 * Performs this operation on the given argument.
	 *
	 * @param value
	 *            the input argument
	 */
	public void accept( float t );


	/**
	 * Returns a composed {@code FloatConsumer} that performs, in sequence, this operation followed by the {@code after}
	 * operation. If performing either operation throws an exception, it is relayed to the caller of the composed
	 * operation. If performing this operation throws an exception, the {@code after} operation will not be performed.
	 *
	 * @param after
	 *            the operation to perform after this operation
	 * @return a composed {@code FloatConsumer} that performs in sequence this operation followed by the {@code after}
	 *         operation
	 * @throws NullPointerException
	 *             if {@code after} is null
	 */
	default FloatConsumer andThen( final FloatConsumer after )
	{
		Objects.requireNonNull( after );
		return ( final float t ) -> {
			this.accept( t );
			after.accept( t );
		};
	}
}
