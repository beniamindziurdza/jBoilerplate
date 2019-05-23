package org.jboilerplate.ddd.repository;

import java.io.Serializable;
import org.jboilerplate.ddd.aggregate.AggregateRoot;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <R> aggregate root class/interface (role interface)
 * @param <I> identity
 */
public interface ICanFindAggregateByRootEntityId<R extends AggregateRoot, I extends Serializable> {
    R findAggregateByRootEntityId(I identity);
}
