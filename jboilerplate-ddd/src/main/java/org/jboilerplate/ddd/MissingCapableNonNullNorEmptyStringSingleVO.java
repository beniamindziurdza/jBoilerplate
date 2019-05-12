package org.jboilerplate.ddd;

import java.util.function.Consumer;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO> missing capable VO
 */
public abstract class MissingCapableNonNullNorEmptyStringSingleVO<VO extends MissingCapableNonNullNorEmptyStringSingleVO<VO>>
        extends MissingCapableSingleVO<VO, String> implements MissingCapable<VO> {
            
    @Override
    protected ValidationResult validateMe() {
        return ValidationResult.of( !attribute.isEmpty() );  // checking if underlying attribute value denotes missing is done elsewhere during creation of VO (in verifyMissing())
    }
    
    public static <VO extends MissingCapableNonNullNorEmptyStringSingleVO<VO>> VO createOrGetMissingIfNullOrEmptyAttribute(
            Class<VO> clazz, String attribute) {
        return createOrGetMissingIf(clazz, attribute, (String a) -> a == null || a.isEmpty() );
    }
    
    public static <VO extends MissingCapableNonNullNorEmptyStringSingleVO<VO>> CreationResult<VO> tryCreateOrGetMissingIfNullOrEmptyAttribute(
            Class<VO> clazz, String attribute) {
        return tryCreateOrGetMissingIf(clazz, attribute, (String a) -> a == null || a.isEmpty() );
    }
    
    public static <VO extends MissingCapableNonNullNorEmptyStringSingleVO<VO>> CreationResult<VO> tryCreateOrGetMissingIfNullOrEmptyAttribute(
            Consumer<ValidationResult> validationResultConsumer, Class<VO> clazz, String attribute) {
        return tryCreateOrGetMissingIf(validationResultConsumer, clazz, attribute, (String a) -> a == null || a.isEmpty() );
    }
}
