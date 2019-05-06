package org.jboilerplate.jinq;

import org.jboilerplate.ddd.SpecificationOf;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T>
 */
public interface WhereSpecificationOf<T extends Object> extends SpecificationOf<T>  {        
    public WherePredicate<T> wherePredicate();    
}
