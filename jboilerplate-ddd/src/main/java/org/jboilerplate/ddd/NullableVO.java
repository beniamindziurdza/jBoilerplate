package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
/**
 *
 * @author Beniamin.Dziurdza
 * @param <voT>
 * @param <A>
 */
public abstract class NullableVO<voT extends NullableVO<voT,A>, A>
        extends VO<voT,A>
        implements ValueObject { 

    @Override 
    protected ValidationResult validateMe() {
        return ValidationResult.satisfied();
    }
}
