package org.jboilerplate.ddd.exception;

import org.jboilerplate.ddd.validation.ValidationResult;
import org.jboilerplate.ddd.info.DomainInfo;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class DomainException extends RuntimeException {

    protected ValidationResult validationResult;
    
    protected DomainInfo domainInfo;
    
    protected Throwable inner;
    
    public DomainException(Throwable inner) {
        this.inner = inner;
    }
    
    public DomainException(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }
        
//    public DomainException(DomainInfo domainInfo) {
//        this.domainInfo = domainInfo;
//    }
    
}
