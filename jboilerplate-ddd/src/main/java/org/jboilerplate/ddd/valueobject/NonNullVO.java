package org.jboilerplate.ddd.valueobject;

import org.jboilerplate.ddd.validation.ValidationResult;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <voT>
 * @param <A>
 */
public abstract class NonNullVO<voT extends NonNullVO<voT,A>, A>
        extends VO<voT,A>
        implements ValueObject { 

    @Override 
    protected ValidationResult validateMe() {
        return ValidationResult.of(attribute != null); 
    }
}
