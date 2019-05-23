package org.jboilerplate.ddd.creation;

import org.jboilerplate.ddd.validation.ValidationResult;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Result of creating new instance. Unlike {@link Optional}, the instance
 * obtained from <code>this</code> via i.&nbsp;e. {@link getInstanceOrNullOrThrow()}
 * can be <code>null</code> in some cases.
 * <p>One can check if validation is satisfied (and <code>this</code> contains
 * valid result) by calling {@link isPresent()}
 * 
 * @author Beniamin.Dziurdza
 * @param <T> new instance type
 */
public class CreationResult<T> {
        
    public CreationResult(T createdInstance, ValidationResult validationResult) {
        this.instance = validationResult.isSatisfied() ? createdInstance : null; // never keep invalid instance
        this.validationResult = validationResult;
    }
        
    protected T instance;

    /**
     * @return created instance or <code>null</code>, if validation is satisfied
     * @throws NoSuchElementException if validation is <b>not</b> satisfied
     */
    public T getInstanceOrNullOrThrow() {
        if (isEmpty()) throw new NoSuchElementException();
        return instance;
    }
    
    /**
     * @return {@link Optional} containing instance or <code>null</code>,
     * if validation is satisfied
     * @throws NoSuchElementException if validation is <b>not</b> satisfied
     */
    public Optional<T> getOptionalInstanceOrThrow() {
        if (isEmpty()) throw new NoSuchElementException();
        return Optional.ofNullable(instance);
    }    
    
    public boolean isPresent() {
        return validationResult.isSatisfied();
    }
    
    public boolean isEmpty() {
        return !validationResult.isSatisfied();
    }
    
    /**
     * @param other
     * @return created instance or <code>null</code>, if validation is satisfied
     * or <code>other</code>, otherwise.
     */    
    public T orElse(T other) {
        if (isEmpty()) return other;
        return instance;
    }
        
    protected ValidationResult validationResult;
    public ValidationResult getValidationResult() {
        return validationResult;
    }            
}
