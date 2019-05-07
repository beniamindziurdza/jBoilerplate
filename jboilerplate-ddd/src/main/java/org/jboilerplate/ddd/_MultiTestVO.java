package org.jboilerplate.ddd;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author Beniamin.Dziurdza
 */
class _MultiTestVO extends MultiVO<_MultiTestVO> {
        
    public static _MultiTestVO createOrGetNull(int x, Object obj) { // can throw ValidationDomainException
        return getVerifiedInstanceOrNullIfAllAttributesAreNull(new _MultiTestVO(x, obj));        
    }
    
    public static CreationResult<_MultiTestVO> tryCreateOrGetNull(int x, Object obj) {
        return getCreationResultOfInstanceOrNullIfAllAttributesAreNull(new _MultiTestVO(x, obj));
    }
    
    public static CreationResult<_MultiTestVO> ConsumeValidationResultAndTryCreateOrGetNull(ValidationResultBuilder vrb, int x, Object obj) {
        return consumeValidationResultAndGetCreationResultOfInstanceOrNullIfAllAttributesAreNull(vrb::appendValidationResult, new _MultiTestVO(x, obj));
    }
        
    protected _MultiTestVO(int x, Object obj) {
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
    protected IValidationResult validateMe() {
        return new ValidationResult(!this.allAttributesAreNull());
    }
}
