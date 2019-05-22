package org.jboilerplate.ddd;

//import java.util.List;

/**
 * 
 * Marks that
 * <ol>
 * <li> entity <code>E</code> is an aggregate root directly (as <code>E</code>) - <code>E implements AggregateRoot&lt;E,I&gt;</code> 
 * </li>
 * <li> or/and some Role interface is a specialized aggregate root over <code>E</code> (with the same Identity) - 
 * <code>Role implements AggregateRoot&lt;E,I&gt;</code> and <code>E implements R</code>.
 * </li>
 * </ol>
 * @author Beniamin.Dziurdza

 * @param <E> entity
 * @param <I> identity
 */
public interface AggregateRoot<E extends DomainEntity<E,I>, I extends DomainIdentity> extends DomainEntity<E, I> {
}


