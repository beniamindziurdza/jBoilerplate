package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza

 * @param <V> 
 * @param <A>
 */
public abstract class MissingCapableSingleVO<V extends MissingCapableSingleVO<V,A>, A>
        extends SingleVO<V, A>
        implements MissingCapable<V> {
                
    public static <V extends MissingCapableSingleVO<V, A>, A> V createOrGetMissing(Class<V> clazz, A attribute) {        
        V vo = SingleVO.createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        if (vo.equals(vo.missing())) return vo.missing();        
        vo.verify();        
        return vo;        
    }    
    protected MissingCapableSingleVO() {        
    }
            
    @Override
    protected V verify() {        
        verifyMissing();
        super.verify();
        return (V) this;
    }
            
}
