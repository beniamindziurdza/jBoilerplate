package org.jboilerplate.ddd.specification;

import org.jboilerplate.ddd.specification.SpecificationOf;
import org.jboilerplate.ddd.validation.ValidatorOf;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T>
 */
public interface ValidatingSpecificationOf<T> extends SpecificationOf<T>, ValidatorOf<T> {
    
}
