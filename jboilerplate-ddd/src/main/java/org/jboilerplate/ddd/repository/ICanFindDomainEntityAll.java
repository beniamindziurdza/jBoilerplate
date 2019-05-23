package org.jboilerplate.ddd.repository;

import java.util.List;
import org.jboilerplate.ddd.entity.DomainEntity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 */
public interface ICanFindDomainEntityAll<E extends DomainEntity> {
    List<E> findAll();
}
