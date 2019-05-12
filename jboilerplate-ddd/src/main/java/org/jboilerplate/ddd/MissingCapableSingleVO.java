package org.jboilerplate.ddd;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author Beniamin.Dziurdza

 * @param <VO> 
 * @param <A>
 */
public abstract class MissingCapableSingleVO<VO extends MissingCapableSingleVO<VO,A>, A>
        extends SingleVO<VO, A>
        implements MissingCapable<VO> {
                
    /**
     * Factory method of <code>MissingCapableSingleVO</code>
     * @param <VO> Value Object type
     * @param <A> Attribute type
     * @param clazz <code>Class&lt;VO&gt;</code> instance
     * @param attribute Attribute of Value Object
     * @return Obtain missing of required <code>clazz</code>
     * if <code>attribute</code> equals missing attribute.
     * Otherwise, a new Value Object instance is returned.
     */
    public static <VO extends MissingCapableSingleVO<VO, A>, A> VO createOrGetMissing(Class<VO> clazz, A attribute) {        
       return createOrGetMissingIf(clazz, attribute, (A a) -> false);
    }    
    
    /**
     * Factory method of <code>MissingCapableSingleVO</code>
     * @param <VO> Value Object type
     * @param <A> Attribute type
     * @param clazz <code>Class&lt;VO&gt;</code> instance
     * @param attribute Attribute of Value Object
     * @param hasToReturnMissing Predicate deciding about returning MissingValue
     * @return Obtain missing of required <code>clazz</code>
     * if <code>hasToReturnMissing</code> predicate is true for a given <code>attribute</code>
     * or <code>attribute</code> equals missing attribute.
     * Otherwise, a new Value Object instance is returned.
     */
    public static <VO extends MissingCapableSingleVO<VO, A>, A> VO createOrGetMissingIf(
            Class<VO> clazz, A attribute, Predicate<A> hasToReturnMissing) {
        VO vo = SingleVO.createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        if (hasToReturnMissing.test(attribute) || vo.equals(vo.missing())) return vo.missing();        
        return vo.verify();             
    }
    
    public static <VO extends MissingCapableSingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetMissingIf(
            Class<VO> clazz, A attribute, Predicate<A> hasToReturnMissing) {
        VO vo = SingleVO.createNonInitializedInstance(clazz);
        vo.setAttribute(attribute);
        if (hasToReturnMissing.test(attribute) || vo.equals(vo.missing())) return new CreationResult<>(vo.missing(), ValidationResult.satisfied());
        vo.verifyMissing();
        ValidationResult validationResult = vo.validateMe();                
        return new CreationResult<>(validationResult.isSatisfied() ? vo : null, validationResult);
    }
    
    public static <VO extends MissingCapableSingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetMissing(
            Class<VO> clazz, A attribute) {
        return tryCreateOrGetMissingIf(clazz, attribute, (A a) -> false);
    }    
        
    public static <VO extends MissingCapableSingleVO<VO, A>, A> CreationResult<VO> tryCreateOrGetMissingIf(
            Consumer<ValidationResult> validationResultConsumer, Class<VO> clazz, A attribute, Predicate<A> hasToReturnMissing) {        
        CreationResult creationResult = tryCreateOrGetMissingIf(clazz, attribute, hasToReturnMissing);
        validationResultConsumer.accept(creationResult.getValidationResult());
        return creationResult;
    }
               
    protected MissingCapableSingleVO() {
    }
            
    @Override
    protected VO verify() {        
        verifyMissing();
        super.verify();
        return (VO) this;
    }
            
}
