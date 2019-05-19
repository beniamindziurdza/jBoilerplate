package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <E>
 * @param <I>
 */
public interface ICanFindById<E extends DomainEntity<E,I>, I extends DomainIdentity> {
    E findOrGetNull(I identity);        
}
