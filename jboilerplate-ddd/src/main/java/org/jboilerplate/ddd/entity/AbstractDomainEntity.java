package org.jboilerplate.ddd.entity;

import java.util.Objects;
import org.jboilerplate.ddd.identity.DomainIdentity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public abstract class AbstractDomainEntity<E extends AbstractDomainEntity<E,I>, I extends DomainIdentity> implements DomainEntity<E, I> {
    
    protected I identity;
    @Override
    public I identity() {
        return identity;
    }
    
    @Override
    public boolean canEqual(Object o) {
        return this.getClass().isInstance(o);
    }
    
    @Override
    public int hashCode() {
        return identity() == null ? 0 : identity().hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            E other = (E) o;
            return other.canEqual(this) && Objects.equals(this.identity(), other.identity());
        }
        return false;        
    }
    
}
