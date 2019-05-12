package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class DomainException extends RuntimeException {

    protected ValidationResult validationResult;
    
    public DomainException(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }
    
}
