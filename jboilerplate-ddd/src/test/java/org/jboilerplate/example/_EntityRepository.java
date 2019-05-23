package org.jboilerplate.example;

import org.jboilerplate.ddd.repository.ICanFindDomainEntityAll;
import org.jboilerplate.ddd.repository.ICanFindDomainEntityById;


/**
 *
 * @author Beniamin.Dziurdza
 */
public interface _EntityRepository extends ICanFindDomainEntityById<_Entity, _Identity>, 
            ICanFindDomainEntityAll<_Entity> { 
}
