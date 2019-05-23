package org.jboilerplate.ddd.entity;

import java.io.Serializable;
import org.jboilerplate.ddd.identity.DomainIdentity;
import org.jboilerplate.ddd.equality.ICanEqual;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <EntityT> Entity
 * @param <IdentityT> Domain Identity
 */
public interface DomainEntity<EntityT, IdentityT extends DomainIdentity>
        extends ICanEqual, Serializable {

    public IdentityT identity();
        
}
