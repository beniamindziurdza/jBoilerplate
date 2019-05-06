package org.jboilerplate.ddd;


/**
 *
 * @author Beniamin.Dziurdza
 * @param <T> class type of instance that will be validated
 */
public interface ValidatorOf<T> {
                
    public IValidationResult validate(T instance);
    
}
