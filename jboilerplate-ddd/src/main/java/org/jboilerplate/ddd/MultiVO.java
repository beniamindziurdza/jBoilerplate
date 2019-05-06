package org.jboilerplate.ddd;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <V> Value Object class
 */
public abstract class MultiVO<V extends MultiVO<V>> 
        extends AbstractVO<V>
        implements ValueObject {
     
    protected MultiVO() {
    }
    
    @Override
    protected void verify() {        
    }

    protected abstract List<Function<MultiVO<V>, Object>> getAccessors();
 
    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            V other = (V) o;
            if (other.canEqual(this)) {
                List<Function<MultiVO<V>, Object>> thisAccesors = this.getAccessors();
                List<Function<MultiVO<V>, Object>> otherAccesors = other.getAccessors();
                if (thisAccesors.size() != otherAccesors.size()) return false;
                for (int i = 0; i < thisAccesors.size(); i++)
                    if (!Objects.equals(thisAccesors.get(i).apply(this), otherAccesors.get(i).apply(other)))
                        return false;
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {        
        return getAccessors().stream()
                .mapToInt(accessor -> Objects.hashCode(accessor.apply(this)))
                .reduce((op1, op2)->op1*23 + op2).getAsInt();
    }
        
    @Override
    public String attributesToString() {
        return getAccessors().stream()
                .map(f -> Objects.toString(f.apply(this).toString()))
                .collect(Collectors.joining(", "));
    }
    
}
