package org.jboilerplate.ddd;

import java.util.function.Consumer;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <voT> missing capable VO
 */
public abstract class MissingCapableNonNullNorEmptyStringSingleVO<voT extends MissingCapableNonNullNorEmptyStringSingleVO<voT>>
        extends MissingCapableVO<voT, String> implements MissingCapable<voT> {
            
    @Override
    protected ValidationResult validateMe() {
        return ValidationResult.of( !attribute.isEmpty() );  // checking if underlying attribute value denotes missing is done elsewhere during creation of VO (in verifyMissing())
    }
    
    public static <voT extends MissingCapableNonNullNorEmptyStringSingleVO<voT>> voT createOrGetMissingIfNullOrEmptyAttribute(
            Class<voT> clazz, String attribute) {
        return createOrGetMissingIf(clazz, attribute, (String a) -> a == null || a.isEmpty() );
    }
    
    public static <voT extends MissingCapableNonNullNorEmptyStringSingleVO<voT>> CreationResult<voT> tryCreateOrGetMissingIfNullOrEmptyAttribute(
            Class<voT> clazz, String attribute) {
        return tryCreateOrGetMissingIf(clazz, attribute, (String a) -> a == null || a.isEmpty() );
    }
    
    public static <voT extends MissingCapableNonNullNorEmptyStringSingleVO<voT>> CreationResult<voT> tryCreateOrGetMissingIfNullOrEmptyAttribute(
            Consumer<ValidationResult> validationResultConsumer, Class<voT> clazz, String attribute) {
        return tryCreateOrGetMissingIf(validationResultConsumer, clazz, attribute, (String a) -> a == null || a.isEmpty() );
    }
}
