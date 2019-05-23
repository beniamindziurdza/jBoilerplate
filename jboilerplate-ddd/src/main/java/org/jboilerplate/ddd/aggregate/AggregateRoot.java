package org.jboilerplate.ddd.aggregate;


/**
 * 
 * Marking interface; that
 * <ol>
 * <li> entity <code>E</code> is an aggregate root directly (as <code>E</code>) - <code>E implements AggregateRoot</code>
 * </li>
 * <li> or/and some Role interface is a specialized aggregate root over entity <code>E</code> (with the same Identity) - 
 * <code>Role implements AggregateRoot</code> and <code>E implements R</code>.
 * </li>
 * </ol>
 * @author Beniamin.Dziurdza
 */
public interface AggregateRoot {

}


