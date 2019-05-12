package org.jboilerplate.ddd;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Beniamin.Dziurdza
 */
public interface ValidationResult {    
    boolean isSatisfied();
    Optional<DomainMessage> subject();
    List<DomainMessage> failureReasons();
    List<DomainMessage> warnings(); 
    List<ValidationResult> subresults();
    
    static ValidationResult of(boolean isSatisfied) {
        return isSatisfied ? SimpleValidationResult.SATISFIED : SimpleValidationResult.NOT_SATISFIED;
    }
    
    static ValidationResult satisfied() {
        return SimpleValidationResult.SATISFIED;
    }
    
    static ValidationResult notSatisfied() {
        return SimpleValidationResult.NOT_SATISFIED;
    }
    
}
