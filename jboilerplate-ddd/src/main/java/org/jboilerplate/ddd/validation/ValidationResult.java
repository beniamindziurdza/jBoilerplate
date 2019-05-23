package org.jboilerplate.ddd.validation;

import java.util.List;
import java.util.Optional;
import org.jboilerplate.ddd.info.DomainInfo;

/**
 *
 * @author Beniamin.Dziurdza
 */
public interface ValidationResult {    
    boolean isSatisfied();
    Optional<DomainInfo> subject();
    List<DomainInfo> failureReasons();
    List<DomainInfo> warnings(); 
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
