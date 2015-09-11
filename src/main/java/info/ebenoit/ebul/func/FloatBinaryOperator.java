package info.ebenoit.ebul.func;


import java.util.function.BinaryOperator;



/**
 * Represents an operation upon two <code>float</code>-valued operands and producing a <code>float</code>-valued result.
 * This is the primitive type specialisation of {@link BinaryOperator} for <code>float</code>.
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is
 * {@link #applyAsFloat(float, float)}.
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface FloatBinaryOperator
{

	/**
	 * Applies this operator to the given operands.
	 *
	 * @param t
	 *            the first operand
	 * @param u
	 *            the second operand
	 * @return the result
	 * @throws FunctionException
	 *             if a checked exception occurs
	 */
	public float applyAsFloat( float t , float u );

}
