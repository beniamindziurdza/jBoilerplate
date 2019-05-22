package org.jboilerplate.ddd;

import java.io.Serializable;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <I>
 */
public interface ICanObtainNewIdentity<I extends Serializable> {
    I nextIdentity();
}

