package org.jboilerplate.example;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.jboilerplate.ddd.validation.CompositeValidationResultBuilder;
import org.jboilerplate.ddd.creation.CreationResult;
import org.jboilerplate.ddd.valueobject.MultiVO;
import org.jboilerplate.ddd.validation.SimpleValidationResult;
import org.jboilerplate.ddd.validation.ValidationResult;

/**
 *
 * @author Beniamin.Dziurdza
 */
class _MultiTestVO extends MultiVO<_MultiTestVO> {
        
    public static _MultiTestVO createOrGetNull(int x, Object obj) {
        return getVerifiedInstanceOrNullIfNullAllAttributes(new _MultiTestVO(x, obj));        
    }
    
    public static CreationResult<_MultiTestVO> tryCreateOrGetNull(int x, Object obj) {
        return getCreationResultOfInstanceOrNullIfNullAllAttributes(new _MultiTestVO(x, obj));
    }
    
    public static CreationResult<_MultiTestVO> tryCreateOrGetNull(CompositeValidationResultBuilder vrb, int x, Object obj) {
        return getCreationResultOfInstanceOrNullIfNullAllAttributes(vrb::appendValidationResult, new _MultiTestVO(x, obj));
    }
        
    protected _MultiTestVO(int x, Object obj) {
        this.x = x;
        this.obj = obj;
    }

    Integer x;
    public Integer getX() {
        return x;
    }

    Object obj;
    public Object getObj() {
        return obj;
    }

    public static List<Function<MultiVO<_MultiTestVO>, Object>> ACCESSORS
            =  Collections.unmodifiableList(java.util.Arrays.asList(
                instance -> ((_MultiTestVO) instance).x,
                instance -> ((_MultiTestVO) instance).obj //getObj()
            ));
            
    @Override
    protected List<Function<MultiVO<_MultiTestVO>, Object>> getAccessors() {
        return ACCESSORS;
    }

    @Override
    protected ValidationResult validateMe() {
        return new SimpleValidationResult(!this.allAttributesAreNull());
    }
}
