package org.jboilerplate.ddd;

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
