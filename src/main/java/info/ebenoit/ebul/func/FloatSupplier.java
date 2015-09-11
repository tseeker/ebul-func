package info.ebenoit.ebul.func;


/**
 * Represents a supplier of {@code float}-valued results. This is the {@code float}-producing primitive specialisation
 * of {@link java.util.function.Supplier}.
 *
 * <p>
 * There is no requirement that a distinct result be returned each time the supplier is invoked.
 *
 * <p>
 * This is a {@link java.util.function functional interface} whose functional method is {@link #getAsFloat()}.
 *
 * @see java.util.function.Supplier
 *
 * @author <a href="mailto:ebenoit@ebenoit.info">E. Benoît</a>
 */
@FunctionalInterface
public interface FloatSupplier
{

	/**
	 * Gets a result.
	 *
	 * @return a result
	 */
	public float getAsFloat( );
}
