package org.jboilerplate.jinq;

import java.util.List;
import org.jboilerplate.ddd.DomainEntity;
import org.jboilerplate.ddd.DomainIdentity;


/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public interface ICanFindBySpecification<E extends DomainEntity<E,I>, I extends DomainIdentity> {
        
    List<E> find(WhereSpecificationOf<E> specification);    
}
