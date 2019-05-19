package org.jboilerplate.jinq.infrastructure;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.jboilerplate.ddd.DomainEntity;
import org.jboilerplate.ddd.DomainIdentity;
import org.jboilerplate.ddd.ICanCountAll;
import org.jboilerplate.ddd.ICanFindAll;
import org.jboilerplate.ddd.ICanFindById;
import org.jboilerplate.jinq.ICanCountBySpecification;
import org.jboilerplate.jinq.ICanFindBySpecification;
import org.jboilerplate.jinq.WhereSpecificationOf;
import org.jinq.jpa.JinqJPAStreamProvider;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public abstract class JinqJPARepository<E extends DomainEntity<E,I>, I extends DomainIdentity> 
        implements ICanFindById<E,I>, ICanFindAll<E>, ICanCountAll<E>,
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
