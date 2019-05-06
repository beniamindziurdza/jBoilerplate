package org.jboilerplate.ddd;

import java.util.List;

/**
 *
 * @author Beniamin.Dziurdza
 */
public interface IValidationResult {    
    boolean isSatisfied();
    List<DomainMessage> failureReasons();
    List<DomainMessage> warnings();    
}
