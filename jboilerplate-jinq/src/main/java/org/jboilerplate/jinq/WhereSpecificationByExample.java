package org.jboilerplate.jinq;

import java.util.Objects;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T> type specified
 * @param <S> specification
 * @param <V> example value 
 */
public abstract class WhereSpecificationByExample<T, S extends WhereSpecificationByExample<T,S,V>, V> extends WhereSpecification<T>  {
    protected static <T,S,V> S createNonInitialized(Class<S> specClazz) {
        try {
            return specClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new IllegalArgumentException("Cannot create instance of " + Objects.toString(specClazz), ex);
        }
    }
    
    public static <T,S extends WhereSpecificationByExample<T,S,V>, V> S create(Class<S> specClazz, V example) {
        S specification = createNonInitialized(specClazz);
        specification.initializeParameter(example);
        specification.verify();
        return specification;
    }
        
    protected WhereSpecificationByExample() {}
    
    protected V parameter;
    protected void initializeParameter(V vo) {
        this.parameter = vo;                
    }
    
    protected abstract WherePredicate<T> wherePredicateFor(V example);
    
    @Override
    public WherePredicate<T> wherePredicate() {
        return wherePredicateFor(parameter);
    }
    
    protected abstract void verify();

    
}
