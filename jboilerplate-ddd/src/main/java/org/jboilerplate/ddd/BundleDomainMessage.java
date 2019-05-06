package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class BundleDomainMessage implements IBundleMessage {
        
    public BundleDomainMessage(String bundle, String key, Object[] parameters) {
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
