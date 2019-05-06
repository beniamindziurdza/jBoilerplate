package org.jboilerplate.ddd;



/**
 *
 * @author Beniamin.Dziurdza
 * @param <V>
 */
public abstract class MissingCapableMultiVO<V extends MissingCapableMultiVO<V>> 
        extends MultiVO<V>
        implements MissingCapable<V> {
    
    protected MissingCapableMultiVO() {        
    }
            
    @Override
    protected void verify() {        
        verifyMissing();
        super.verify();
    }    
}
