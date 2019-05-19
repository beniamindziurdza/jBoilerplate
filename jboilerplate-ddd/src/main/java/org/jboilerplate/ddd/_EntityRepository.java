package org.jboilerplate.ddd;


/**
 *
 * @author Beniamin.Dziurdza
 */
public interface _EntityRepository extends ICanFindById<_Entity, _Identity>, 
            ICanFindAll<_Entity> { 
}
