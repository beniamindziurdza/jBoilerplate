package org.jboilerplate.jinq;

import javax.persistence.EntityManager;
import org.jboilerplate.ddd.DomainEntity;
import org.jboilerplate.ddd.DomainIdentity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public abstract class JPARepository<E extends DomainEntity<E,I>, I extends DomainIdentity> {
    protected abstract EntityManager entityManager();
    protected abstract Class<E> entityClass();
}
