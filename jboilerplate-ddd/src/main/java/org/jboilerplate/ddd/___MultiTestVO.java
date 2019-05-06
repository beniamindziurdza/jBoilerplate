package org.jboilerplate.ddd;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author Beniamin.Dziurdza
 */
class ___MultiTestVO extends MultiVO<___MultiTestVO> {
          
    // the only public way to create instance. Could return Missing/Special/NUll object instead of null
    public static ___MultiTestVO create(Integer x, Object obj) {

        ___MultiTestVO vo = MultiVO.createNonInitializedInstance(___MultiTestVO.class);

        vo.setObj(obj);
        vo.setX(x);

        return vo;
    }

    protected ___MultiTestVO() {
        super();
    }

    Integer x;
    public Integer getX() {
        return x;
    }
    protected void setX(Integer x) {
        this.x = x;
    }

    Object obj;
    public Object getObj() {
        return obj;
    }
    protected void setObj(Object obj) {
        this.obj = obj;
    }

    public static List<Function<MultiVO<___MultiTestVO>, Object>> ACCESSORS
            =  Collections.unmodifiableList(java.util.Arrays.asList(
                instance -> ((___MultiTestVO) instance).x,
                instance -> ((___MultiTestVO) instance).getObj()
            ));
            
    @Override
    protected List<Function<MultiVO<___MultiTestVO>, Object>> getAccessors() {
        return ACCESSORS;
    }

}
