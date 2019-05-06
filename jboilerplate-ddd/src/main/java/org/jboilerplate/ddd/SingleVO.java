package org.jboilerplate.ddd;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
//import javax.persistence.*;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <V> domain value object class
 * @param <A> immutable type of value object attribute
 */
//@MappedSuperclass
//@Embeddable
public abstract class SingleVO<V extends SingleVO<V,A>, A>
        extends AbstractVO<V>
        implements ValueObject {

    public static <V extends SingleVO<V, A>, A> V createOrGetValueIf(Class<V> clazz, A attribute, V value, Predicate<A> hasToReturnValue) {
        if (hasToReturnValue.test(attribute)) return value;
        V vo = createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        return vo.verify();
    }
    
    public static <V extends SingleVO<V, A>, A> V create(Class<V> clazz, A attribute) {
        return createOrGetValueIf(clazz, attribute, null, (A a) -> false );
    }
    
    public static <V extends SingleVO<V, A>, A> V createOrGetValueIfAttributeIsNull(Class<V> clazz, A attribute, V value) {
        return createOrGetValueIf(clazz, attribute, value, (A a) -> a == null );
    }
    
    public static <V extends SingleVO<V, A>, A> V createOrGetNullIfAttributeIsNull(Class<V> clazz, A attribute) {
        return createOrGetValueIf(clazz, attribute, null, (A a) -> a == null );
    }
        
    public static <V extends SingleVO<V, A>, A> CreationResult<V> tryCreateOrGetValueIf(Class<V> clazz, A attribute, V value, Predicate<A> hasToReturnValue) {
        if (hasToReturnValue.test(attribute)) return new CreationResult<>(value, new ValidationResult(true));
        V vo = createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);        
        IValidationResult validationResult = vo.validateMe();                
        return new CreationResult<>(validationResult.isSatisfied() ? vo : null, validationResult);
    }
        
    public static <V extends SingleVO<V, A>, A> CreationResult<V> tryCreate(Class<V> clazz, A attribute) {
        return tryCreateOrGetValueIf(clazz, attribute, null, (A a) -> false);
    } 

    public static <V extends SingleVO<V, A>, A> CreationResult<V> tryCreateOrGetValueIfAttributeIsNull(Class<V> clazz, A attribute, V value) {
        return tryCreateOrGetValueIf(clazz, attribute, value, (A a) -> a == null);
    }

    public static <V extends SingleVO<V, A>, A> CreationResult<V> tryCreateOrGetNullIfAttributeIsNull(Class<V> clazz, A attribute) {
        return tryCreateOrGetValueIf(clazz, attribute, null, (A a) -> a == null);
    }
    
    public static <V extends SingleVO<V, A>, A> CreationResult<V> consumeValidationResultAndTryCreateOrGetValueIf(
            Consumer<IValidationResult> validationResultConsumer, Class<V> clazz, A attribute, V value, Predicate<A> hasToReturnValue) {
       CreationResult<V> result = tryCreateOrGetValueIf(clazz, attribute, value, hasToReturnValue);
       validationResultConsumer.accept(result.validationResult);
       return result;
    }
      
    public static <V extends SingleVO<V, A>, A> CreationResult<V> consumeValidationResultAndTryCreate(Consumer<IValidationResult> validationResultConsumer, Class<V> clazz, A attribute) {
        return consumeValidationResultAndTryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, null, (A a) -> false);
    }

    public static <V extends SingleVO<V, A>, A> CreationResult<V> consumeValidationResultAndTryCreateOrGetValueIfAttributeIsNull(
            Consumer<IValidationResult> validationResultConsumer, Class<V> clazz, A attribute, V value) {
        return  consumeValidationResultAndTryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, value, (A a) -> a == null);
    }
    
    public static <V extends SingleVO<V, A>, A> CreationResult<V> consumeValidationResultAndTryCreateOrGetNullIfAttributeIsNull(
            Consumer<IValidationResult> validationResultConsumer, Class<V> clazz, A attribute) {
        return  consumeValidationResultAndTryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, null, (A a) -> a == null);
    }
    
    protected SingleVO() {
    }
    
    protected A attribute;
    public A attribute() {
        return attribute;
    }
    void setAttribute(A attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this.getClass().isInstance(o)) {
            V other = (V) o;
            return other.canEqual(this) && Objects.equals(this.attribute, other.attribute);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.attribute);
        return hash;
    }
       
    @Override
    public String attributesToString() {
        return Objects.toString( attribute().toString() );
    }
}
