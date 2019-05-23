package org.jboilerplate.ddd.valueobject;

import org.jboilerplate.ddd.missing.MissingCapable;



/**
 *
 * @author Beniamin.Dziurdza
 * @param <voT>
 */
public abstract class MissingCapableMultiVO<voT extends MissingCapableMultiVO<voT>> 
        extends MultiVO<voT>
        implements MissingCapable<voT> {
            
    protected MissingCapableMultiVO() {        
    }
                            
    @Override
    protected voT verify() {        
        verifyMissing();
        super.verify();
        return (voT) this;
    }    
}
