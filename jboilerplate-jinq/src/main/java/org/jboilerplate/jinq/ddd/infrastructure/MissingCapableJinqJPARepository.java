package org.jboilerplate.jinq.ddd.infrastructure;

import org.jboilerplate.ddd.entity.DomainEntity;
import org.jboilerplate.ddd.identity.DomainIdentity;
import org.jboilerplate.ddd.missing.MissingCapable;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public abstract class MissingCapableJinqJPARepository<E extends DomainEntity<E,I>, I extends DomainIdentity> extends JinqJPARepository<E, I>
        implements MissingCapable<E> { // forcesth like MissingCapableDomainEntity
    
    final E missing = MissingCapable.getMissingOf(entityClass);

    @Override
    public E missing() {
        return missing;
    }    
    
    public E findOrGetMissing(I identity) {
        E result = entityManager().find(entityClass(), identity);                 
        return result != null ? result : missing();
    }        
    
}
