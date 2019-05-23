package org.jboilerplate.ddd.info;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class BundleDomainInfo implements IBundleDomainInfo {
        
    public BundleDomainInfo(String bundle, String key, Object[] parameters) {
        this.bundle = bundle;
        this.key = key;
        this.parameters = parameters;
    }
        
    protected String bundle;
    @Override
    public String bundle() {
        return bundle;
    }

    protected String key;
    @Override
    public String key() {
        return key;
    }

    protected Object[] parameters;
    @Override
    public Object[] parameters() {
        return parameters;
    }
    
}
