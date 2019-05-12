package org.jboilerplate.ddd;

import java.util.Objects;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO> Value Object class
 */
public abstract class AbstractVO<VO extends AbstractVO<VO> > implements ValueObject {
    
    protected static <VO extends AbstractVO<VO>> VO createNonInitializedInstance(Class<VO> clazz) {
        VO vo;
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
    
    protected VO verify() {
        ValidationResult validationResult = validateMe();
        if (!validationResult.isSatisfied()) throw DomainExceptionOf(validationResult);
        return (VO) this;
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
