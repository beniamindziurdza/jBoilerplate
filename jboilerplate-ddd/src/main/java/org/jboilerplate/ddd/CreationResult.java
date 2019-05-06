package org.jboilerplate.ddd;

import java.util.NoSuchElementException;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T> new instance type
 */
public class CreationResult<T> {
        
    public CreationResult(T createdInstance, IValidationResult validationResult) {
        this.instance = validationResult.isSatisfied() ? createdInstance : null; // never keep invalid instance - watch out your resources!
        this.validationResult = validationResult;
    }
        
    protected T instance;
    public T getInstanceOrThrow() {
        if (isEmpty()) throw new NoSuchElementException();
        return instance;
    }
    
    public boolean isPresent() {
        return validationResult.isSatisfied();
    }
    
    public boolean  isEmpty() {
        return !validationResult.isSatisfied();
    }
    
    public T orElse(T other) {
        if (isEmpty()) return other;
        return instance;
    }
    
    protected IValidationResult validationResult;
    public IValidationResult getValidationResult() {
        return validationResult;
    }            
}
