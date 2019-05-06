package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T>
 */
public interface ValidatingSpecificationOf<T> extends SpecificationOf<T>, ValidatorOf<T> {
    
}
