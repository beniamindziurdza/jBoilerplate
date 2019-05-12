package org.jboilerplate.ddd;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO> Value Object class
 */
public abstract class MultiVO<VO extends MultiVO<VO>> extends AbstractVO<VO> implements ValueObject {
    
    protected static <VO extends MultiVO<VO>> VO getVerifiedInstanceOrValueIf(VO notVerifiedYet, VO value, Predicate<VO> hasToReturnValue) {
        VO vo = notVerifiedYet;
        if (hasToReturnValue.test(vo)) return value;
        return vo.verify();
    }    
    
    protected static <VO extends MultiVO<VO>> VO getVerifiedInstance(VO notVerifiedYet) {        
        return getVerifiedInstanceOrValueIf(notVerifiedYet, null, (VO v) -> false );
    }
    
    protected static <VO extends MultiVO<VO>> VO getVerifiedInstanceOrValueIfNullAllAttributes(VO notVerifiedYet, VO value) {        
        return getVerifiedInstanceOrValueIf(notVerifiedYet, value, (VO v) -> v.allAttributesAreNull() );
    }

    protected static <VO extends MultiVO<VO>> VO getVerifiedInstanceOrNullIfNullAllAttributes(VO notVerifiedYet) {        
        return getVerifiedInstanceOrValueIf(notVerifiedYet, null, (VO v) -> v.allAttributesAreNull() );
    }    

    protected static <VO extends MultiVO<VO>> CreationResult<VO> getCreationResultOfInstanceOrValueIf(VO notValidatedYet, VO value, Predicate<VO> hasToReturnValue) {
        VO vo = notValidatedYet;
        if (hasToReturnValue.test(vo)) return new CreationResult<>(value, ValidationResult.satisfied());
        ValidationResult validationResult = vo.validateMe();
        return new CreationResult<>(validationResult.isSatisfied() ? vo : null, validationResult);
    }
    
    protected static <VO extends MultiVO<VO>> CreationResult<VO> getCreationResultOfInstance(VO notVerifiedYet) {        
        return getCreationResultOfInstanceOrValueIf(notVerifiedYet, null, (VO v) -> false );
    }
    
    protected static <VO extends MultiVO<VO>> CreationResult<VO> getCreationResultOfInstanceOrValueIfNullAllAttributes(VO notVerifiedYet, VO value) {        
        return getCreationResultOfInstanceOrValueIf(notVerifiedYet, value, (VO v) -> v.allAttributesAreNull() );
    }
        
    protected static <VO extends MultiVO<VO>> CreationResult<VO> getCreationResultOfInstanceOrNullIfNullAllAttributes(VO notVerifiedYet) {        
        return getCreationResultOfInstanceOrValueIf(notVerifiedYet, null, (VO v) -> v.allAttributesAreNull() );
    }
        
    protected static <VO extends MultiVO<VO>> CreationResult<VO> getCreationResultOfInstanceOrValueIf(
            Consumer<ValidationResult> validationResultConsumer, VO notValidatedYet, VO value, Predicate<VO> hasToReturnValue) {
        CreationResult<VO> creationResult = getCreationResultOfInstanceOrValueIf(notValidatedYet, value, hasToReturnValue);
        validationResultConsumer.accept(creationResult.getValidationResult());
        return creationResult;
    }
    
    protected static <VO extends MultiVO<VO>> CreationResult<VO> getCreationResultOfInstance(
            Consumer<ValidationResult> validationResultConsumer, VO notValidatedYet) {
        return getCreationResultOfInstanceOrValueIf(validationResultConsumer, notValidatedYet, null, (VO v) -> false );
    }
    
    protected static <VO extends MultiVO<VO>> CreationResult<VO> getCreationResultOfInstanceOrValueIfNullAllAttributes(
        Consumer<ValidationResult> validationResultConsumer, VO notValidatedYet, VO value) {
        return getCreationResultOfInstanceOrValueIf(validationResultConsumer, notValidatedYet, value, (VO v) -> v.allAttributesAreNull());
    }

    protected static <VO extends MultiVO<VO>> CreationResult<VO> getCreationResultOfInstanceOrNullIfNullAllAttributes(
        Consumer<ValidationResult> validationResultConsumer, VO notValidatedYet) {
        return getCreationResultOfInstanceOrValueIf(validationResultConsumer, notValidatedYet, null, (VO v) -> v.allAttributesAreNull());
    }
    
    protected boolean allAttributesAreNull() {
        return getAccessors().stream().allMatch(accessor -> accessor.apply(this) == null);
    }
  
    protected MultiVO() {
    }
    
    protected abstract List<Function<MultiVO<VO>, Object>> getAccessors();
 
    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            VO other = (VO) o;
            if (other.canEqual(this)) {
                List<Function<MultiVO<VO>, Object>> thisAccesors = this.getAccessors();
                List<Function<MultiVO<VO>, Object>> otherAccesors = other.getAccessors();
                if (thisAccesors.size() != otherAccesors.size()) return false;
                for (int i = 0; i < thisAccesors.size(); i++)
                    if (!Objects.equals(thisAccesors.get(i).apply(this), otherAccesors.get(i).apply(other)))
                        return false;
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {        
        return getAccessors().stream()
                .mapToInt(accessor -> Objects.hashCode(accessor.apply(this)))
                .reduce((op1, op2)->op1*23 + op2).getAsInt();
    }
        
    @Override
    public String attributesToString() {
        return getAccessors().stream()
                .map(f -> Objects.toString(f.apply(this).toString()))
                .collect(Collectors.joining(", "));
    }
    
}
