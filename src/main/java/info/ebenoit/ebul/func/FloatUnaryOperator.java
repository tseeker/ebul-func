package info.ebenoit.ebul.func;


import java.util.Objects;



/**
 * Represents an operation on a single {@code float}-valued operand that produces a {@code float}-valued result. This is
 * the primitive type specialisation of {@link java.util.function.UnaryOperator} for {@code float}.
 *
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is {@link #applyAsFloat(float)}.
 *
 * @see java.util.function.UnaryOperator
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface FloatUnaryOperator
{

	/**
	 * Applies this operator to the given operand.
	 *
	 * @param operand
	 *            the operand
	 * @return the operator result
	 */
	public float applyAsFloat( float operand );


	/**
	 * Returns a composed operator that first applies the {@code before} operator to its input, and then applies this
	 * operator to the result. If evaluation of either operator throws an exception, it is relayed to the caller of the
	 * composed operator.
	 *
	 * @param before
	 *            the operator to apply before this operator is applied
	 * @return a composed operator that first applies the {@code before} operator and then applies this operator
	 * @throws NullPointerException
	 *             if before is null
	 *
	 * @see #andThen(FloatUnaryOperator)
	 */
	default FloatUnaryOperator compose( final FloatUnaryOperator before )
	{
		Objects.requireNonNull( before );
		return ( final float v ) -> this.applyAsFloat( before.applyAsFloat( v ) );
	}


	/**
	 * Returns a composed operator that first applies this operator to its input, and then applies the {@code after}
	 * operator to the result. If evaluation of either operator throws an exception, it is relayed to the caller of the
	 * composed operator.
	 *
	 * @param after
	 *            the operator to apply after this operator is applied
	 * @return a composed operator that first applies this operator and then applies the {@code after} operator
	 * @throws NullPointerException
	 *             if after is null
	 *
	 * @see #compose(FloatUnaryOperator)
	 */
	default FloatUnaryOperator andThen( final FloatUnaryOperator after )
	{
		Objects.requireNonNull( after );
		return ( final float t ) -> after.applyAsFloat( this.applyAsFloat( t ) );
	}


	/**
	 * Returns a unary operator that always returns its input argument.
	 *
	 * @return a unary operator that always returns its input argument
	 */
	public static FloatUnaryOperator identity( )
	{
		return t -> t;
	}
}
