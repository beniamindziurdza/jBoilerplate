package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO>
 * @param <A>
 */
public abstract class NullableSingleVO<VO extends NullableSingleVO<VO,A>, A>
        extends SingleVO<VO,A>
        implements ValueObject { 

    @Override 
    protected ValidationResult validateMe() {
        return ValidationResult.satisfied();
    }
}
