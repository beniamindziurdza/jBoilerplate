package org.jboilerplate.ddd.entity;

import java.util.Objects;
import org.jboilerplate.ddd.identity.DomainIdentity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E> domain entity
 * @param <I> identity of entity
 */
public abstract class BaseDomainEntity<E extends BaseDomainEntity<E, I>, I extends DomainIdentity> implements DomainEntity<E, I> {
        
    protected BaseDomainEntity() {
        
    }
    
    protected I id;
    
    @Override
    public I identity() {
        return id;
    }
    
    @Override
    public boolean canEqual(Object o) {                
        return this.getClass().isInstance(o);        
    }
    
    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            E other = (E) o;
            return other.canEqual(this) && Objects.equals(this.id, other.id);
        }
        return false;        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
}
