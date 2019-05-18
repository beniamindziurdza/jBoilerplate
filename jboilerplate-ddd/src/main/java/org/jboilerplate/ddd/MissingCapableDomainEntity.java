package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E> domain entity type
 * @param <I> domain identity type
 */
public abstract class MissingCapableDomainEntity<E extends MissingCapableDomainEntity<E,I>, I extends DomainIdentity>
        extends AbstractDomainEntity<E, I> implements MissingCapable<E> {
    
}
