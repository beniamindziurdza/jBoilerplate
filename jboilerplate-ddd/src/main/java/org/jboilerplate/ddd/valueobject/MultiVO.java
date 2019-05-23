package org.jboilerplate.ddd.valueobject;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.jboilerplate.ddd.creation.CreationResult;
import org.jboilerplate.ddd.validation.ValidationResult;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <voT> Value Object class
 */
public abstract class MultiVO<voT extends MultiVO<voT>> extends AbstractVO<voT> implements ValueObject {
    
    protected static <voT extends MultiVO<voT>> voT getVerifiedInstanceOrValueIf(voT notVerifiedYet, voT value, Predicate<voT> hasToReturnValue) {
        voT vo = notVerifiedYet;
        if (hasToReturnValue.test(vo)) return value;
        return vo.verify();
    }    
    
    protected static <voT extends MultiVO<voT>> voT getVerifiedInstance(voT notVerifiedYet) {        
        return getVerifiedInstanceOrValueIf(notVerifiedYet, null, (voT v) -> false );
    }
    
    protected static <voT extends MultiVO<voT>> voT getVerifiedInstanceOrValueIfNullAllAttributes(voT notVerifiedYet, voT value) {        
        return getVerifiedInstanceOrValueIf(notVerifiedYet, value, (voT v) -> v.allAttributesAreNull() );
    }

    protected static <voT extends MultiVO<voT>> voT getVerifiedInstanceOrNullIfNullAllAttributes(voT notVerifiedYet) {        
        return getVerifiedInstanceOrValueIf(notVerifiedYet, null, (voT v) -> v.allAttributesAreNull() );
    }    

    protected static <voT extends MultiVO<voT>> CreationResult<voT> getCreationResultOfInstanceOrValueIf(voT notValidatedYet, voT value, Predicate<voT> hasToReturnValue) {
        voT vo = notValidatedYet;
        if (hasToReturnValue.test(vo)) return new CreationResult<>(value, ValidationResult.satisfied());
        ValidationResult validationResult = vo.validateMe();
        return new CreationResult<>(validationResult.isSatisfied() ? vo : null, validationResult);
    }
    
    protected static <voT extends MultiVO<voT>> CreationResult<voT> getCreationResultOfInstance(voT notVerifiedYet) {        
        return getCreationResultOfInstanceOrValueIf(notVerifiedYet, null, (voT v) -> false );
    }
    
    protected static <voT extends MultiVO<voT>> CreationResult<voT> getCreationResultOfInstanceOrValueIfNullAllAttributes(voT notVerifiedYet, voT value) {        
        return getCreationResultOfInstanceOrValueIf(notVerifiedYet, value, (voT v) -> v.allAttributesAreNull() );
    }
        
    protected static <voT extends MultiVO<voT>> CreationResult<voT> getCreationResultOfInstanceOrNullIfNullAllAttributes(voT notVerifiedYet) {        
        return getCreationResultOfInstanceOrValueIf(notVerifiedYet, null, (voT v) -> v.allAttributesAreNull() );
    }
        
    protected static <voT extends MultiVO<voT>> CreationResult<voT> getCreationResultOfInstanceOrValueIf(
            Consumer<ValidationResult> validationResultConsumer, voT notValidatedYet, voT value, Predicate<voT> hasToReturnValue) {
        CreationResult<voT> creationResult = getCreationResultOfInstanceOrValueIf(notValidatedYet, value, hasToReturnValue);
        validationResultConsumer.accept(creationResult.getValidationResult());
        return creationResult;
    }
    
    protected static <voT extends MultiVO<voT>> CreationResult<voT> getCreationResultOfInstance(
            Consumer<ValidationResult> validationResultConsumer, voT notValidatedYet) {
        return getCreationResultOfInstanceOrValueIf(validationResultConsumer, notValidatedYet, null, (voT v) -> false );
    }
    
    protected static <voT extends MultiVO<voT>> CreationResult<voT> getCreationResultOfInstanceOrValueIfNullAllAttributes(
        Consumer<ValidationResult> validationResultConsumer, voT notValidatedYet, voT value) {
        return getCreationResultOfInstanceOrValueIf(validationResultConsumer, notValidatedYet, value, (voT v) -> v.allAttributesAreNull());
    }

    protected static <voT extends MultiVO<voT>> CreationResult<voT> getCreationResultOfInstanceOrNullIfNullAllAttributes(
        Consumer<ValidationResult> validationResultConsumer, voT notValidatedYet) {
        return getCreationResultOfInstanceOrValueIf(validationResultConsumer, notValidatedYet, null, (voT v) -> v.allAttributesAreNull());
    }
    
    protected boolean allAttributesAreNull() {
        return getAccessors().stream().allMatch(accessor -> accessor.apply(this) == null);
    }
  
    protected MultiVO() {
    }
    
    protected abstract List<Function<MultiVO<voT>, Object>> getAccessors();
 
    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            voT other = (voT) o;
            if (other.canEqual(this)) {
                List<Function<MultiVO<voT>, Object>> thisAccesors = this.getAccessors();
                List<Function<MultiVO<voT>, Object>> otherAccesors = other.getAccessors();
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
