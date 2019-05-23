package org.jboilerplate.ddd.validation;


/**
 *
 * @author Beniamin.Dziurdza
 * @param <T> class type of instance that will be validated
 */
public interface ValidatorOf<T> {
                
    public ValidationResult validate(T instance);
    
}
