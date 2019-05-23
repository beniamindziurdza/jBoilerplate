package org.jboilerplate.jinq.ddd.specification;

import org.jboilerplate.ddd.specification.SpecificationOf;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T>
 */
public interface WhereSpecificationOf<T extends Object> extends SpecificationOf<T>  {        
    public WherePredicate<T> wherePredicate();    
}
