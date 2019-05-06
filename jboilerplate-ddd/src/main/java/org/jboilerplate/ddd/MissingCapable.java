package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <V>
 */
public interface MissingCapable<V> {
    
    V missing();
           
    default boolean isMissing() {
        return this.equals(missing());
    }    
    
    default void verifyMissing() {        
        if (isMissing()) {
            throw new IllegalArgumentException(this.getClass().getName() + ": missing attribute(s)" );
        }
    }   
}
