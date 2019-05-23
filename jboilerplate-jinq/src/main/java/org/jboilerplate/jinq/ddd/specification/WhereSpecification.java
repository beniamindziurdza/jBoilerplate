package org.jboilerplate.jinq.ddd.specification;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T>
 * 
 * Possibly maximum of reducing boilerplate code with JINQ...
 */
public abstract class WhereSpecification<T> implements WhereSpecificationOf<T>  {

    @Override
    public abstract WherePredicate<T> wherePredicate();
        
    @Override
    public boolean test(T t) { // here we provide implementation of Predicate; wherePredicate is reused; but in practice both method can be overiden
        return wherePredicate().where(t);
    }    
}
