package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 */
public interface ICanCountAll<E extends DomainEntity> {
    long countAll();
}
