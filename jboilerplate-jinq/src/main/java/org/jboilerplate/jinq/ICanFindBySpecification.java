package org.jboilerplate.jinq;

import java.util.List;
import javax.persistence.EntityManager;
import org.jboilerplate.ddd.DomainEntity;
import org.jboilerplate.ddd.DomainIdentity;
import org.jinq.jpa.JinqJPAStreamProvider;

/**
 *
 * @author Beniamin.Dziurdza
 */
public interface ICanFindBySpecification<E extends DomainEntity<E,I>, I extends DomainIdentity> {
    
    EntityManager entityManager();
    Class<E> entityClass();
    
    default List<E> find(WhereSpecificationOf<E> specification) {                                
        JinqJPAStreamProvider streams = new JinqJPAStreamProvider(entityManager().getMetamodel());
                        
        return streams.streamAll(entityManager(), entityClass()).where(specification.wherePredicate()).toList();
    }
}
