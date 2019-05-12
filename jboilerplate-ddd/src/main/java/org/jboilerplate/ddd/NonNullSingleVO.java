package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO>
 * @param <A>
 */
public abstract class NonNullSingleVO<VO extends NonNullSingleVO<VO,A>, A>
        extends SingleVO<VO,A>
        implements ValueObject { 

    @Override 
    protected ValidationResult validateMe() {
        return ValidationResult.of(attribute != null); 
    }
}
