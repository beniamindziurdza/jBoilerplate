package org.jboilerplate.ddd.repository;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 */
public interface ICanPersistDomainEntity<E> {
    void persist(E entity);
}
