package org.jboilerplate.jinq.ddd.specification;

import org.jboilerplate.ddd.entity.DomainEntity;
import org.jboilerplate.ddd.identity.DomainIdentity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public interface ICanCountBySpecification<E extends DomainEntity<E,I>, I extends DomainIdentity> {
        
    long count(WhereSpecificationOf<E> specification);    
}
