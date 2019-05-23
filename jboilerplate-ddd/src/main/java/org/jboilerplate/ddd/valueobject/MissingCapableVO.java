package org.jboilerplate.ddd.valueobject;

import java.util.function.Consumer;
import java.util.function.Predicate;
import org.jboilerplate.ddd.creation.CreationResult;
import org.jboilerplate.ddd.missing.MissingCapable;
import org.jboilerplate.ddd.validation.ValidationResult;


/**
 *
 * @author Beniamin.Dziurdza

 * @param <voT> 
 * @param <A>
 */
public abstract class MissingCapableVO<voT extends MissingCapableVO<voT,A>, A>
        extends VO<voT, A>
        implements MissingCapable<voT> {
                
    /**
     * Factory method of <code>MissingCapableVO</code>
     * @param <voT> Value Object type
     * @param <A> Attribute type
     * @param clazz <code>Class&lt;VO&gt;</code> instance
     * @param attribute Attribute of Value Object
     * @return Obtain missing of required <code>clazz</code>
     * if <code>attribute</code> equals missing attribute.
     * Otherwise, a new Value Object instance is returned.
     */
    public static <voT extends MissingCapableVO<voT, A>, A> voT createOrGetMissing(Class<voT> clazz, A attribute) {        
       return createOrGetMissingIf(clazz, attribute, (A a) -> false);
    }    
    
    /**
     * Factory method of <code>MissingCapableVO</code>
     * @param <voT> Value Object type
     * @param <A> Attribute type
     * @param clazz <code>Class&lt;VO&gt;</code> instance
     * @param attribute Attribute of Value Object
     * @param hasToReturnMissing Predicate deciding about returning MissingValue
     * @return Obtain missing of required <code>clazz</code>
     * if <code>hasToReturnMissing</code> predicate is true for a given <code>attribute</code>
     * or <code>attribute</code> equals missing attribute.
     * Otherwise, a new Value Object instance is returned.
     */
    public static <voT extends MissingCapableVO<voT, A>, A> voT createOrGetMissingIf(
            Class<voT> clazz, A attribute, Predicate<A> hasToReturnMissing) {
        voT vo = VO.createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        if (hasToReturnMissing.test(attribute) || vo.equals(vo.missing())) return vo.missing();        
        return vo.verify();             
    }
    
    public static <voT extends MissingCapableVO<voT, A>, A> CreationResult<voT> tryCreateOrGetMissingIf(
            Class<voT> clazz, A attribute, Predicate<A> hasToReturnMissing) {
        voT vo = VO.createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        if (hasToReturnMissing.test(attribute) || vo.equals(vo.missing())) return new CreationResult<>(vo.missing(), ValidationResult.satisfied());
        vo.verifyMissing();
        ValidationResult validationResult = vo.validateMe();                
        return new CreationResult<>(validationResult.isSatisfied() ? vo : null, validationResult);
    }
    
    public static <voT extends MissingCapableVO<voT, A>, A> CreationResult<voT> tryCreateOrGetMissing(
            Class<voT> clazz, A attribute) {
        return tryCreateOrGetMissingIf(clazz, attribute, (A a) -> false);
    }    
        
    public static <voT extends MissingCapableVO<voT, A>, A> CreationResult<voT> tryCreateOrGetMissingIf(
            Consumer<ValidationResult> validationResultConsumer, Class<voT> clazz, A attribute, Predicate<A> hasToReturnMissing) {        
        CreationResult creationResult = tryCreateOrGetMissingIf(clazz, attribute, hasToReturnMissing);
        validationResultConsumer.accept(creationResult.getValidationResult());
        return creationResult;
    }
               
    protected MissingCapableVO() {
    }
            
    @Override
    protected voT verify() {        
        verifyMissing();
        super.verify();
        return (voT) this;
    }
            
}
