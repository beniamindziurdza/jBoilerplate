package org.jboilerplate.ddd.valueobject;

import org.jboilerplate.ddd.validation.ValidationResult;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <voT>
 */
public abstract class NonNullNorEmptyStringVO<voT extends NonNullNorEmptyStringVO<voT>>
        extends NonNullVO<NonNullNorEmptyStringVO<voT>, String> {
    @Override
    protected ValidationResult validateMe() {
        ValidationResult result = super.validateMe();
        if (!result.isSatisfied()) return result;        
        return ValidationResult.of(!attribute.isEmpty());
    }
}
