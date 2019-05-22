package org.jboilerplate.jinq.infrastructure;

import org.jboilerplate.ddd.DomainEntity;
import org.jboilerplate.ddd.DomainIdentity;


/**
 * TODO: R&D ;)
 * @author Beniamin.Dziurdza
 * @param <R> aggregate root of aggregate being retrieved; R can be seen as specific Role played by aggregate root entity
 * @param <E> domain entity backing aggregate root R
 * @param <I> identity of aggregate root (domain entity)
 */
public abstract class JinqJPATheSameEntityAsAggregateRootRepository <R, E extends DomainEntity<E,I>, I extends DomainIdentity> {
//        implements ICanFindAggregateById<R,I>, ICanFindAllAggregates<R>, ICanCountAllAggregates<R>,
//                ICanFindAggregatesBySpecification<R,E,I>, ICanCountBySpecification<R,E,I> {
                                                    
}
