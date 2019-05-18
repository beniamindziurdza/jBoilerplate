package org.jboilerplate.ddd;



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
