package org.jboilerplate.ddd;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
//import javax.persistence.*;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO> domain value object class
 * @param <A> immutable type of value object attribute
 */
//@MappedSuperclass
//@Embeddable
public abstract class SingleVO<VO extends SingleVO<VO,A>, A>
        extends AbstractVO<VO>
        implements ValueObject {

    public static <VO extends SingleVO<VO, A>, A> VO createOrGetValueIf(Class<VO> clazz, A attribute, VO value, Predicate<A> hasToReturnValue) {
        if (hasToReturnValue.test(attribute)) return value;
        VO vo = createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        return vo.verify();
    }
    
    public static <VO extends SingleVO<VO, A>, A> VO create(Class<VO> clazz, A attribute) {
        return createOrGetValueIf(clazz, attribute, null, (A a) -> false );
    }
    
    public static <VO extends SingleVO<VO, A>, A> VO createOrGetValueIfNullAttribute(Class<VO> clazz, A attribute, VO value) {
        return createOrGetValueIf(clazz, attribute, value, (A a) -> a == null );
    }
    
    public static <VO extends SingleVO<VO, A>, A> VO createOrGetNullIfNullAttribute(Class<VO> clazz, A attribute) {
        return createOrGetValueIf(clazz, attribute, null, (A a) -> a == null );
    }
        
    public static <VO extends SingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetValueIf(Class<VO> clazz, A attribute, VO value, Predicate<A> hasToReturnValue) {
        if (hasToReturnValue.test(attribute)) return new CreationResult<>(value, ValidationResult.satisfied());
        VO vo = createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);        
        ValidationResult validationResult = vo.validateMe();                
        return new CreationResult<>(validationResult.isSatisfied() ? vo : null, validationResult);
    }
        
    public static <VO extends SingleVO<VO, A>, A> CreationResult<VO> tryCreate(Class<VO> clazz, A attribute) {
        return tryCreateOrGetValueIf(clazz, attribute, null, (A a) -> false);
    } 

    public static <VO extends SingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetValueIfNullAttribute(Class<VO> clazz, A attribute, VO value) {
        return tryCreateOrGetValueIf(clazz, attribute, value, (A a) -> a == null);
    }

    public static <VO extends SingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetNullIfNullAttribute(Class<VO> clazz, A attribute) {
        return tryCreateOrGetValueIf(clazz, attribute, null, (A a) -> a == null);
    }
    
    public static <VO extends SingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetValueIf(
            Consumer<ValidationResult> validationResultConsumer, Class<VO> clazz, A attribute, VO value, Predicate<A> hasToReturnValue) {
       CreationResult<VO> result = tryCreateOrGetValueIf(clazz, attribute, value, hasToReturnValue);
       validationResultConsumer.accept(result.validationResult);
       return result;
    }
      
    public static <VO extends SingleVO<VO, A>, A> CreationResult<VO> tryCreate(Consumer<ValidationResult> validationResultConsumer, Class<VO> clazz, A attribute) {
        return tryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, null, (A a) -> false);
    }

    public static <VO extends SingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetValueIfNullAttribute(
            Consumer<ValidationResult> validationResultConsumer, Class<VO> clazz, A attribute, VO value) {
        return  tryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, value, (A a) -> a == null);
    }
    
    public static <VO extends SingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetNullIfNullAttribute(
            Consumer<ValidationResult> validationResultConsumer, Class<VO> clazz, A attribute) {
        return  tryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, null, (A a) -> a == null);
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
            VO other = (VO) o;
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
