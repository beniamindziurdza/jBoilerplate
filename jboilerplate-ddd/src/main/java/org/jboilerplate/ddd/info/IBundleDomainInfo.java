package org.jboilerplate.ddd.info;

/**
 *
 * @author Beniamin.Dziurdza
 */
public interface IBundleDomainInfo extends DomainInfo {
    String bundle();
    String key();
    Object [] parameters();
}
