package org.jboilerplate.ddd;

import java.util.Objects;
//import javax.persistence.*;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <V> domain value object class
 * @param <A> immutable type of value object attribute
 */
//@MappedSuperclass
//@Embeddable
public abstract class SingleVO<V extends SingleVO<V,A>, A>
        extends AbstractVO<V>
        implements ValueObject {

    protected SingleVO() {
    }

    protected A attribute;

    public A attribute() {
        return attribute;
    }

    void setAttribute(A attribute) {
        this.attribute = attribute;
    }

    public static <V extends SingleVO<V, A>, A> V createOrGetValueIfAttributeIsNull(Class<V> clazz, A attribute, V value) {

        if (attribute == null)
            return value;
        V vo = createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        vo.verify();

        return vo;
    }
        
    @Override
    protected void verify() {        
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            V other = (V) o;
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
