package org.jboilerplate.jinq.ddd.specification;

import java.io.Serializable;
import java.util.List;
import org.jboilerplate.ddd.entity.DomainEntity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public interface ICanFindBySpecification<E extends DomainEntity<E,I>, I extends Serializable> {
        
    List<E> find(WhereSpecificationOf<E> specification);    
}
