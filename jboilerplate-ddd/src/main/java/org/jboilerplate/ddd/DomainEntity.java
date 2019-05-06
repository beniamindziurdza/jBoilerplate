package org.jboilerplate.ddd;

import java.io.Serializable;

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
