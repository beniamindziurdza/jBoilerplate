package org.jboilerplate.example;

import org.jboilerplate.ddd.AggregateRoot;
import org.jboilerplate.ddd.BaseDomainEntity;



/**
 *
 * @author Beniamin.Dziurdza
 */
public class _Entity extends BaseDomainEntity<_Entity, _Identity>
        implements _Role1, _Role2, AggregateRoot<_Entity, _Identity> {
}
