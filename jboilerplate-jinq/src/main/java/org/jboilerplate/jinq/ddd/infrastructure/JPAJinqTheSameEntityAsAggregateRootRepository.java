package org.jboilerplate.jinq.ddd.infrastructure;

import java.io.Serializable;
import org.jboilerplate.ddd.entity.DomainEntity;
import org.jboilerplate.ddd.identity.DomainIdentity;


/**
 * TODO: R&D ;)
 * @author Beniamin.Dziurdza
 * @param <R> aggregate root of aggregate being retrieved; R can be seen as specific Role played by aggregate root entity
 * @param <E> domain entity backing aggregate root R
 * @param <I> identity of aggregate root (domain entity)
 */
public abstract class JPAJinqTheSameEntityAsAggregateRootRepository <R, E extends DomainEntity<E,I>, I extends Serializable> {
//        implements ICanFindAggregateById<R,I>, ICanFindAllAggregates<R>, ICanCountAllAggregates<R>,
//                ICanFindAggregatesBySpecification<R,E,I>, ICanCountBySpecification<R,E,I> {
                                                    
}
