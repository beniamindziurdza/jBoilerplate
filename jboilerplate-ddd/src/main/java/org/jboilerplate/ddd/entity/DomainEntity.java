package org.jboilerplate.ddd.entity;

import java.io.Serializable;
import org.jboilerplate.ddd.equality.ICanEqual;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <EntityT> Entity
 * @param <IdentityT> Identity of entity
 */
public interface DomainEntity<EntityT, IdentityT extends Serializable>
        extends ICanEqual, Serializable {

    public IdentityT identity();
        
}
