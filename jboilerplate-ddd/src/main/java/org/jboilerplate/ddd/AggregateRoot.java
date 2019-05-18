package org.jboilerplate.ddd;

//import java.util.List;

/**
 *
 * Marking interface that defines that entity plays role as a root of an aggregate
 * 
 * @author Beniamin.Dziurdza

 * @param <E> entity
 * @param <I> identity
 */
public interface AggregateRoot<E extends DomainEntity<E,I>, I extends DomainIdentity> extends DomainEntity<E, I> {
    

        // <R> List<Class<?>> eagerlyFetched(); 
}


