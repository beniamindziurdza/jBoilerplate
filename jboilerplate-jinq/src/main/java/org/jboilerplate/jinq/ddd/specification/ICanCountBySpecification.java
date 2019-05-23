package org.jboilerplate.jinq.ddd.specification;

import java.io.Serializable;
import org.jboilerplate.ddd.entity.DomainEntity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public interface ICanCountBySpecification<E extends DomainEntity<E,I>, I extends Serializable> {
        
    long count(WhereSpecificationOf<E> specification);    
}
