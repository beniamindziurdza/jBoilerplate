package org.jboilerplate.ddd.repository;

import org.jboilerplate.ddd.entity.DomainEntity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 */
public interface ICanCountDomainEntityAll<E extends DomainEntity> {
    long countAll();
}
