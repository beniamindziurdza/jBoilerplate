package org.jboilerplate.ddd;

import java.util.Objects;

/**
 *
 * @author Beniamin.Dziurdza

 * @param <V> 
 * @param <A>
 */
public abstract class MissingCapableSingleVO<V extends MissingCapableSingleVO<V,A>, A>
        extends SingleVO<V, A>
        implements MissingCapable<V> {
            
    protected MissingCapableSingleVO() {        
    }
            
    @Override
    protected void verify() {        
        verifyMissing();
        super.verify();
    }
    
    public static <V extends MissingCapableSingleVO<V, A>, A> V createOrGetMissing(Class<V> clazz, A attribute) {        
        V vo = SingleVO.createNonInitializedInstance(clazz);
        if (attribute.equals(vo.missing().attribute)) return vo.missing();
        vo.setAttribute(attribute);
        vo.verify();        
        return vo;        
    }
        
}
