package org.jboilerplate.example;

import org.jboilerplate.ddd.ICanFindAll;
import org.jboilerplate.ddd.ICanFindById;


/**
 *
 * @author Beniamin.Dziurdza
 */
public interface _EntityRepository extends ICanFindById<_Entity, _Identity>, 
            ICanFindAll<_Entity> { 
}
