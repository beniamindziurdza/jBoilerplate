package org.jboilerplate.ddd.repository;

import org.jboilerplate.ddd.entity.DomainEntity;
import org.jboilerplate.ddd.identity.DomainIdentity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public interface ICanFindById<E extends DomainEntity<E,I>, I extends DomainIdentity> {
    E findOrGetNull(I identity);        
}
