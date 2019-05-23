package org.jboilerplate.ddd.missing;

import java.lang.reflect.InvocationTargetException;

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
    
    static <V> V getMissingOf(Class<V> clazz) {        
        V result;        
        try {        
            MissingCapable<V> missingCapable = (MissingCapable<V>) clazz.getDeclaredConstructor().newInstance();
            result = missingCapable.missing();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException 
                | ClassCastException ex) { // | ClassNotFoundException  ?
            throw new UnsupportedOperationException("Cannot obtain missing of Entity; Entity is not MissingCapable or has no parameterless ctor (?)", ex);
        }   
         
        return result;
    }
}
