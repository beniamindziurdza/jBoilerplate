package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
public interface IBundleMessage extends DomainMessage {
    String bundle();
    String key();
    Object [] parameters();
}
