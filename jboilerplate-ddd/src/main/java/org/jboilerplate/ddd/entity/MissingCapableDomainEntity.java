package org.jboilerplate.ddd.entity;

import java.io.Serializable;
import org.jboilerplate.ddd.missing.MissingCapable;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E> domain entity type
 * @param <I> domain identity type
 */
public abstract class MissingCapableDomainEntity<E extends MissingCapableDomainEntity<E,I>, I extends Serializable>
        extends AbstractDomainEntity<E, I> implements MissingCapable<E> {
    
    protected MissingCapableDomainEntity() {
        super();
    }
}
