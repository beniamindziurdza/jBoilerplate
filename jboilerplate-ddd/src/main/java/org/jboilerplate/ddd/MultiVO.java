package org.jboilerplate.ddd;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <V> Value Object class
 */
public abstract class MultiVO<V extends MultiVO<V>> 
        extends AbstractVO<V>
        implements ValueObject {
         
//    protected static <V extends MultiVO<V>> V createOrGetValueIfAllAttributesAreNull(Class<V> clazz, V value, Object... attributes) {
//        V vo = createNonInitializedInstance(clazz);
//        vo.setAttributes(attributes);
//        return getVerifiedInstanceOrValueIfAllAttributesAreNull(vo, value);
//    }    
//        
//    protected abstract void setAttributes(Object ... attributes);
    
    protected static <V extends MultiVO<V>> V getVerifiedInstanceOrValueIf(V initializedButNotVerifiedYetInstance, V value, Predicate<V> hasToReturnValue) {
        V vo = initializedButNotVerifiedYetInstance;
        if (hasToReturnValue.test(vo)) return value;
        return vo.verify();
    }    
    
    protected static <V extends MultiVO<V>> V getVerifiedInstance(V initializedButNotVerifiedYetInstance) {        
        return getVerifiedInstanceOrValueIf(initializedButNotVerifiedYetInstance, null, (V v) -> false );
    }
    
    protected static <V extends MultiVO<V>> V getVerifiedInstanceOrValueIfAllAttributesAreNull(V initializedButNotVerifiedYetInstance, V value) {        
        return getVerifiedInstanceOrValueIf(initializedButNotVerifiedYetInstance, value, (V v) -> v.allAttributesAreNull() );
    }

    protected static <V extends MultiVO<V>> V getVerifiedInstanceOrNullIfAllAttributesAreNull(V initializedButNotVerifiedYetInstance) {        
        return getVerifiedInstanceOrValueIf(initializedButNotVerifiedYetInstance, null, (V v) -> v.allAttributesAreNull() );
    }    

    protected static <V extends MultiVO<V>> CreationResult<V> getCreationResultOfInstanceOrValueIf(V initializedButNotValidatedYetInstance, V value, Predicate<V> hasToReturnValue) {
        V vo = initializedButNotValidatedYetInstance;
        if (hasToReturnValue.test(vo)) return new CreationResult<>(value, new ValidationResult(true));
        IValidationResult validationResult = vo.validateMe();
        return new CreationResult<>(validationResult.isSatisfied() ? vo : null, validationResult);
    }
    
    protected static <V extends MultiVO<V>> CreationResult<V> getCreationResultOfInstance(V initializedButNotVerifiedYetInstance) {        
        return getCreationResultOfInstanceOrValueIf(initializedButNotVerifiedYetInstance, null, (V v) -> false );
    }
    
    protected static <V extends MultiVO<V>> CreationResult<V> getCreationResultOfInstanceOrValueIfAllAttributesAreNull(V initializedButNotVerifiedYetInstance, V value) {        
        return getCreationResultOfInstanceOrValueIf(initializedButNotVerifiedYetInstance, value, (V v) -> v.allAttributesAreNull() );
    }
        
    protected static <V extends MultiVO<V>> CreationResult<V> getCreationResultOfInstanceOrNullIfAllAttributesAreNull(V initializedButNotVerifiedYetInstance) {        
        return getCreationResultOfInstanceOrValueIf(initializedButNotVerifiedYetInstance, null, (V v) -> v.allAttributesAreNull() );
    }
        
    protected static <V extends MultiVO<V>> CreationResult<V> consumeValidationResultAndGetCreationResultOfInstanceOrValueIf(
            Consumer<IValidationResult> validationResultConsumer, V initializedButNotValidatedYetInstance, V value, Predicate<V> hasToReturnValue) {
        CreationResult<V> creationResult = getCreationResultOfInstanceOrValueIf(initializedButNotValidatedYetInstance, value, hasToReturnValue);
        validationResultConsumer.accept(creationResult.getValidationResult());
        return creationResult;
    }
    
    protected static <V extends MultiVO<V>> CreationResult<V> consumeValidationResultAndGetCreationResultOfInstance(
            Consumer<IValidationResult> validationResultConsumer, V initializedButNotValidatedYetInstance) {
        return consumeValidationResultAndGetCreationResultOfInstanceOrValueIf(validationResultConsumer, initializedButNotValidatedYetInstance, null, (V v) -> false );
    }
    
    protected static <V extends MultiVO<V>> CreationResult<V> consumeValidationResultAndGetCreationResultOfInstanceOrValueIfAllAttributesAreNull(
        Consumer<IValidationResult> validationResultConsumer, V initializedButNotValidatedYetInstance, V value) {
        return consumeValidationResultAndGetCreationResultOfInstanceOrValueIf(validationResultConsumer, initializedButNotValidatedYetInstance, value, (V v) -> v.allAttributesAreNull());
    }

    protected static <V extends MultiVO<V>> CreationResult<V> consumeValidationResultAndGetCreationResultOfInstanceOrNullIfAllAttributesAreNull(
        Consumer<IValidationResult> validationResultConsumer, V initializedButNotValidatedYetInstance) {
        return consumeValidationResultAndGetCreationResultOfInstanceOrValueIf(validationResultConsumer, initializedButNotValidatedYetInstance, null, (V v) -> v.allAttributesAreNull());
    }
    
    protected boolean allAttributesAreNull() {
        return getAccessors().stream().allMatch(accessor -> accessor.apply(this) == null);
    }
  
    protected MultiVO() {
    }
    
    protected abstract List<Function<MultiVO<V>, Object>> getAccessors();
 
    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            V other = (V) o;
            if (other.canEqual(this)) {
                List<Function<MultiVO<V>, Object>> thisAccesors = this.getAccessors();
                List<Function<MultiVO<V>, Object>> otherAccesors = other.getAccessors();
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
