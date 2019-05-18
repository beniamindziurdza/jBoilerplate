package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
public interface IBundleDomainMessage extends DomainMessage {
    String bundle();
    String key();
    Object [] parameters();
}
