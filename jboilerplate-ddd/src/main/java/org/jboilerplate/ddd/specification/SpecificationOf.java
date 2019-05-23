package org.jboilerplate.ddd.specification;

import java.io.Serializable;
import java.util.function.Predicate;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T>
 */
public interface SpecificationOf<T> extends Serializable, Predicate<T>  { // prefer composition over inheritance ??
}
