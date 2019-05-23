package org.jboilerplate.example;

import java.util.Objects;
import org.jboilerplate.ddd.valueobject.AbstractVO;
import org.jboilerplate.ddd.missing.MissingCapable;
import org.jboilerplate.ddd.validation.ValidationResult;
import org.jboilerplate.ddd.valueobject.ValueObject;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO>
 * @param <A>
 */
public abstract class __MissingCapableVO<VO extends __MissingCapableVO<VO,A>, A>
        extends AbstractVO<VO>
        implements ValueObject, MissingCapable<VO> {
    
    public abstract class Missing extends __MissingCapableVO<VO, A>  {

    }
    
    @Override
    public VO missing() {
        return (VO) new Missing() {
            @Override
            protected ValidationResult validateMe() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
    protected __MissingCapableVO() {
    }
    
    protected A attribute;
    public A attribute() {
        return attribute;
    }
    void setAttribute(A attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            VO other = (VO) o;
            return other.canEqual(this) && Objects.equals(this.attribute, other.attribute);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.attribute);
        return hash;
    }
       
    @Override
    public String attributesToString() {
        return Objects.toString( attribute().toString() );
    }    
}
