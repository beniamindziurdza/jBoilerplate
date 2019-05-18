package org.jboilerplate.ddd;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
//import javax.persistence.*;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <voT> domain value object class
 * @param <A> immutable type of value object attribute
 */
//@MappedSuperclass
//@Embeddable
public abstract class VO<voT extends VO<voT,A>, A>
        extends AbstractVO<voT>
        implements ValueObject {

    public static <voT extends VO<voT, A>, A> voT createOrGetValueIf(Class<voT> clazz, A attribute, voT value, Predicate<A> hasToReturnValue) {
        if (hasToReturnValue.test(attribute)) return value;
        voT vo = createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        return vo.verify();
    }
    
    public static <voT extends VO<voT, A>, A> voT create(Class<voT> clazz, A attribute) {
        return createOrGetValueIf(clazz, attribute, null, (A a) -> false );
    }
    
    public static <voT extends VO<voT, A>, A> voT createOrGetValueIfNullAttribute(Class<voT> clazz, A attribute, voT value) {
        return createOrGetValueIf(clazz, attribute, value, (A a) -> a == null );
    }
    
    public static <voT extends VO<voT, A>, A> voT createOrGetNullIfNullAttribute(Class<voT> clazz, A attribute) {
        return createOrGetValueIf(clazz, attribute, null, (A a) -> a == null );
    }
        
    public static <voT extends VO<voT, A>, A> CreationResult<voT> tryCreateOrGetValueIf(Class<voT> clazz, A attribute, voT value, Predicate<A> hasToReturnValue) {
        if (hasToReturnValue.test(attribute)) return new CreationResult<>(value, ValidationResult.satisfied());
        voT vo = createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);        
        ValidationResult validationResult = vo.validateMe();                
        return new CreationResult<>(validationResult.isSatisfied() ? vo : null, validationResult);
    }
        
    public static <voT extends VO<voT, A>, A> CreationResult<voT> tryCreate(Class<voT> clazz, A attribute) {
        return tryCreateOrGetValueIf(clazz, attribute, null, (A a) -> false);
    } 

    public static <voT extends VO<voT, A>, A> CreationResult<voT> tryCreateOrGetValueIfNullAttribute(Class<voT> clazz, A attribute, voT value) {
        return tryCreateOrGetValueIf(clazz, attribute, value, (A a) -> a == null);
    }

    public static <voT extends VO<voT, A>, A> CreationResult<voT> tryCreateOrGetNullIfNullAttribute(Class<voT> clazz, A attribute) {
        return tryCreateOrGetValueIf(clazz, attribute, null, (A a) -> a == null);
    }
    
    public static <voT extends VO<voT, A>, A> CreationResult<voT> tryCreateOrGetValueIf(
            Consumer<ValidationResult> validationResultConsumer, Class<voT> clazz, A attribute, voT value, Predicate<A> hasToReturnValue) {
       CreationResult<voT> result = tryCreateOrGetValueIf(clazz, attribute, value, hasToReturnValue);
       validationResultConsumer.accept(result.validationResult);
       return result;
    }
      
    public static <voT extends VO<voT, A>, A> CreationResult<voT> tryCreate(Consumer<ValidationResult> validationResultConsumer, Class<voT> clazz, A attribute) {
        return tryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, null, (A a) -> false);
    }

    public static <voT extends VO<voT, A>, A> CreationResult<VO> tryCreateOrGetValueIfNullAttribute(
            Consumer<ValidationResult> validationResultConsumer, Class<VO> clazz, A attribute, VO value) {
        return  tryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, value, (A a) -> a == null);
    }
    
    public static <voT extends VO<voT, A>, A> CreationResult<voT> tryCreateOrGetNullIfNullAttribute(
            Consumer<ValidationResult> validationResultConsumer, Class<VO> clazz, A attribute) {
        return  tryCreateOrGetValueIf(validationResultConsumer, clazz, attribute, null, (A a) -> a == null);
    }
    
    protected VO() {
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
