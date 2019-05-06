package org.jboilerplate.jinq;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T> type specified
 * @param <S> specification
 * @param <V> example value 
 */
public abstract class MissingCapableWhereSpecificationByExample<T, S extends MissingCapableWhereSpecificationByExample<T,S,V>, V> extends WhereSpecificationByExample<T,S,V> {
    
    @Override
    protected void verify() {
        if (parameter == null) throw new IllegalArgumentException("example value is null");
    }
}
