package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class DomainException extends RuntimeException {

    protected ValidationResult validationResult;
    
    protected DomainMessage domainMessage;
    
    protected Throwable inner;
    
    public DomainException(Throwable inner) {
        this.inner = inner;
    }
    
    public DomainException(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }
        
//    public DomainException(DomainMessage domainMessage) {
//        this.domainMessage = domainMessage;
//    }
    
}
