package org.jboilerplate.ddd;

import java.util.Objects;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <V> Value Object class
 */
public abstract class AbstractVO<V extends AbstractVO<V> > implements ValueObject {
    
    protected static <V extends AbstractVO<V>> V createNonInitializedInstance(Class<V> clazz) {
        V vo;
        try {
            vo = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new IllegalArgumentException("Cannot create instance of " + Objects.toString(clazz), ex);
        }

        return vo;
    }
    
    protected AbstractVO() {
    }
    
    protected IValidationResult validateMe() {
        return new ValidationResult(true);
    }
    
    protected DomainException IValidationResultToDomainException(IValidationResult validationResult) {
        return new DomainException(validationResult);
    }
    
    protected V verify() {
        IValidationResult validationResult = validateMe();
        if (!validationResult.isSatisfied()) throw IValidationResultToDomainException(validationResult);
        return (V) this;
    }
  
    @Override
    public boolean canEqual(Object o) {
        return this.getClass().isInstance(o);
    }

    public abstract String attributesToString();
    
    @Override
    public String toString() {
        return this.getClass().getName() + ": " + attributesToString();
    }    
}
