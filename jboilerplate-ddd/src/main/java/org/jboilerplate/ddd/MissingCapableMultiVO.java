package org.jboilerplate.ddd;



/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO>
 */
public abstract class MissingCapableMultiVO<VO extends MissingCapableMultiVO<VO>> 
        extends MultiVO<VO>
        implements MissingCapable<VO> {
            
    protected MissingCapableMultiVO() {        
    }
                            
    @Override
    protected VO verify() {        
        verifyMissing();
        super.verify();
        return (VO) this;
    }    
}
