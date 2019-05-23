package org.jboilerplate.example;

import org.jboilerplate.ddd.repository.ICanFindAll;
import org.jboilerplate.ddd.repository.ICanFindById;


/**
 *
 * @author Beniamin.Dziurdza
 */
public interface _EntityRepository extends ICanFindById<_Entity, _Identity>, 
            ICanFindAll<_Entity> { 
}
