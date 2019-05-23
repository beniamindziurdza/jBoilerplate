package org.jboilerplate.ddd.valueobject;

import java.util.Objects;
import org.jboilerplate.ddd.exception.DomainException;
import org.jboilerplate.ddd.validation.ValidationResult;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <voT> Value Object class
 */
public abstract class AbstractVO<voT extends AbstractVO<voT> > implements ValueObject {
    
    protected static <voT extends AbstractVO<voT>> voT createNonInitializedInstance(Class<voT> clazz) {
        voT vo;
        try {
            vo = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new IllegalArgumentException("Cannot create instance of " + Objects.toString(clazz), ex);
        }

        return vo;
    }
    
    protected AbstractVO() {
    }
        
    protected abstract ValidationResult validateMe();

    protected DomainException DomainExceptionOf(ValidationResult validationResult) {
        return new DomainException(validationResult);
    }
    
    protected voT verify() {
        ValidationResult validationResult = validateMe();
        if (!validationResult.isSatisfied()) throw DomainExceptionOf(validationResult);
        return (voT) this;
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
