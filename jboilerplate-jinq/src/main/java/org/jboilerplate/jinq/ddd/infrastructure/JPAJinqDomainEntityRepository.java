package org.jboilerplate.jinq.ddd.infrastructure;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.jboilerplate.ddd.entity.DomainEntity;
import org.jboilerplate.jinq.ddd.specification.ICanCountBySpecification;
import org.jboilerplate.jinq.ddd.specification.ICanFindBySpecification;
import org.jboilerplate.jinq.ddd.specification.WhereSpecificationOf;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.jboilerplate.ddd.repository.ICanFindDomainEntityAll;
import org.jboilerplate.ddd.repository.ICanFindDomainEntityById;
import org.jboilerplate.ddd.repository.ICanCountDomainEntityAll;

/**
 *
 * @param <E>
 * @param <I>
 */
public abstract class JPAJinqDomainEntityRepository<E extends DomainEntity<E,I>, I extends Serializable> 
        implements ICanFindDomainEntityById<E,I>, ICanFindDomainEntityAll<E>, ICanCountDomainEntityAll<E>,
                ICanFindBySpecification<E,I>, ICanCountBySpecification<E,I> {
    
    final JinqJPAStreamProvider streams = new JinqJPAStreamProvider(entityManager().getMetamodel());
    final Class<E> entityClass = getGenericTypeByIndex(getClass(), 0);
    
    protected abstract EntityManager entityManager();
    protected Class<E> entityClass() {
        return entityClass;
    }
           
    private static Class getGenericTypeByIndex(final Class clazz, final int index) {
        return (Class) ((ParameterizedType) clazz
                .getGenericSuperclass())
                .getActualTypeArguments()[index];
    }    
    
    @Override
    public E findOrGetNull(I identity) {
        return entityManager().find(entityClass(), identity);             
    }
        
    @Override
    public List<E> find(WhereSpecificationOf<E> specification) {                                                                
        return streams.streamAll(entityManager(), entityClass()).where(specification.wherePredicate()).toList();
    }    

    @Override
    public List<E> findAll() {
        return streams.streamAll(entityManager(), entityClass()).toList();
    }

    @Override
    public long countAll() {
        return streams.streamAll(entityManager(), entityClass()).count();        
    }

    @Override
    public long count(WhereSpecificationOf<E> specification) {
        return streams.streamAll(entityManager(), entityClass()).where(specification.wherePredicate()).count();
    }    
}
