package org.jboilerplate.ddd.repository;

import org.jboilerplate.ddd.aggregate.AggregateRoot;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <R> root of aggregate
 */
public interface ICanPersistAggregate<R extends AggregateRoot> {
    void persist(R aggregateRoot);
}
