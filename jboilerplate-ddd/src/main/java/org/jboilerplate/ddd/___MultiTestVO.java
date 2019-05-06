package org.jboilerplate.ddd;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author Beniamin.Dziurdza
 */
class ___MultiTestVO extends MultiVO<___MultiTestVO> {
        
    public static ___MultiTestVO createOrGetValue(___MultiTestVO value, int x, Object obj) {                      
        return MultiVO.getVerifiedInstanceOrGetValueIfAllAttributesAreNull(new ___MultiTestVO(x, obj), value);        
    }
        
    protected ___MultiTestVO(int x, Object obj) {
        this.x = x;
        this.obj = obj;
    }
        
//    @Override
//    protected void setAttributes(Object... attributes) {
//        x = (int) attributes[0];
//        obj = attributes[1];
//    }
            
    Integer x;
    public Integer getX() {
        return x;
    }

    Object obj;
    public Object getObj() {
        return obj;
    }

    public static List<Function<MultiVO<___MultiTestVO>, Object>> ACCESSORS
            =  Collections.unmodifiableList(java.util.Arrays.asList(
                instance -> ((___MultiTestVO) instance).x,
                instance -> ((___MultiTestVO) instance).obj //getObj()
            ));
            
    @Override
    protected List<Function<MultiVO<___MultiTestVO>, Object>> getAccessors() {
        return ACCESSORS;
    }



}
