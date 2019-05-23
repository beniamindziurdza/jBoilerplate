package org.jboilerplate.jinq.ddd.infrastructure;

import java.io.Serializable;
import org.jboilerplate.ddd.entity.DomainEntity;
import org.jboilerplate.ddd.missing.MissingCapable;

/**
 *
 * @param <E>
 * @param <I>
 */
public abstract class MissingCapableJPAJinqRepository<E extends DomainEntity<E,I>, I extends Serializable>
        extends JPAJinqDomainEntityRepository<E, I>
        implements MissingCapable<E> {
    
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
