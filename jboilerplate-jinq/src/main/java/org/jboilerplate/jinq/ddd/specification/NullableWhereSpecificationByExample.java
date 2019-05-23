package org.jboilerplate.jinq.ddd.specification;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T> type specified
 * @param <S> specification
 * @param <V> example value 
 */
public abstract class NullableWhereSpecificationByExample<T, S extends NullableWhereSpecificationByExample <T,S,V>, V> extends WhereSpecificationByExample<T,S,V> {

    @Override
    protected void verify() {
    }
    
}
