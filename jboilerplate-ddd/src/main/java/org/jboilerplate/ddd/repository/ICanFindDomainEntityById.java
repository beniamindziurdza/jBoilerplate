package org.jboilerplate.ddd.repository;

import java.io.Serializable;
import org.jboilerplate.ddd.entity.DomainEntity;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public interface ICanFindDomainEntityById<E extends DomainEntity<E,I>, I extends Serializable> {
    E findOrGetNull(I identity);        
}
