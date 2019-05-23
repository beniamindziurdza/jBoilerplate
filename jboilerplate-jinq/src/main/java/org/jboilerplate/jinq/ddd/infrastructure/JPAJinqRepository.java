package org.jboilerplate.jinq.ddd.infrastructure;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.jboilerplate.ddd.entity.DomainEntity;
import org.jboilerplate.ddd.identity.DomainIdentity;
import org.jboilerplate.ddd.repository.ICanCountAll;
import org.jboilerplate.ddd.repository.ICanFindAll;
import org.jboilerplate.ddd.repository.ICanFindById;
import org.jboilerplate.jinq.ddd.specification.ICanCountBySpecification;
import org.jboilerplate.jinq.ddd.specification.ICanFindBySpecification;
import org.jboilerplate.jinq.ddd.specification.WhereSpecificationOf;
import org.jinq.jpa.JinqJPAStreamProvider;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public abstract class JPAJinqRepository<E extends DomainEntity<E,I>, I extends DomainIdentity> 
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
