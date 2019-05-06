package org.jboilerplate.ddd;



/**
 *
 * @author Beniamin.Dziurdza
 * @param <V>
 */
public abstract class MissingCapableMultiVO<V extends MissingCapableMultiVO<V>> 
        extends MultiVO<V>
        implements MissingCapable<V> {
        
//    protected static <V extends MissingCapableMultiVO<V>> V createOrGetMissing(Class<V> clazz, Object... attributes) {
//        V vo = MultiVO.createNonInitializedInstance(clazz);       
//        vo.setAttributes(attributes);
//        if (vo.equals(vo.missing())) return vo.missing();
//        vo.verify();        
//        return vo;                
//    }
    
    protected MissingCapableMultiVO() {        
    }
                            
    @Override
    protected V verify() {        
        verifyMissing();
        super.verify();
        return (V) this;
    }    
}
