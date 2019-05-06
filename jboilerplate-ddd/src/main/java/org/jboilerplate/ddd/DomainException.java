package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class DomainException extends RuntimeException {

    protected IValidationResult validationResult;
    
    public DomainException(IValidationResult validationResult) {
        this.validationResult = validationResult;
    }
    
}
