package org.jboilerplate.jinq.ddd.infrastructure;

import org.jboilerplate.ddd.identity.DomainIdentity;

/**
 * TODO R&D ;)
 * @author Beniamin.Dziurdza
 * @param <R>
 * @param <I>
 */
public abstract class JinqJPAAggregateRepository<R, I extends DomainIdentity>  {
//        implements ICanFindAggregateByRootEntityId<R,I>, ICanFindAllAggregates<R>, ICanCountAllAggregates<R>, // possible to implement; seems to be easier in hibernate than eclipseLink
//                ICanFindAggregatesBySpecification<R>, ICanCountBySpecification<R> { // are these last two interfaces possible to implement easily in generic way at all? Or leave them abstract...
    

    /**
     * 
     * Find aggregate root implementing <code>R</code> by its identity.
     * It is implicit polymorhic search since method returns any entity instance that <code>implements R</code>
     * (see Hibernate implicit polymorphic queries) of identity equal to passed <code>identity</code> param;
     * additionaly, one can pass all subclasses of I too (so entities can have various identity type)
     * <p>
     * Can be supported in hibernate, is it possible in eclipseLink ?
     * 
     * @param identity 
     * 
     * @return entity implementing <code>R</code> of given <code>identity</code>
     */
     R findAggregateByRootEntityId(I identity) { // @Override // implementation of ICanFindAggregatesByRootEntityId<R,I>
   
        // algo: 
        // Find via metamodel entityName(s) of entity that (1) implements R
        // and (2) has identifier type equal to given identity param type
          
        // sometimes aggregate is fully identified by tuple: (R,E,I),
        // so there can be more than one result if only entity id is provided
        // when there are more than one entity implementing R
        // with the same identity type. In that case throw exception.          
        // (There could be another method like: R findAggregateByRootEntityId(Class entityClazz, I identity) )                              
                
        // else return entityManager().find(entityName, identity)                    
        return null;        
    }
    
}
