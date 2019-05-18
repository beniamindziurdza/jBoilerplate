package org.jboilerplate.ddd;

import java.util.List;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 */
public interface ICanFindAll<E extends DomainEntity> {
    List<E> findAll();
}
