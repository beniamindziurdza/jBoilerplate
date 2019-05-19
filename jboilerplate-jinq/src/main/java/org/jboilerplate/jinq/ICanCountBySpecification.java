package org.jboilerplate.jinq;

import org.jboilerplate.ddd.DomainEntity;
import org.jboilerplate.ddd.DomainIdentity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public interface ICanCountBySpecification<E extends DomainEntity<E,I>, I extends DomainIdentity> {
        
    long count(WhereSpecificationOf<E> specification);    
}
