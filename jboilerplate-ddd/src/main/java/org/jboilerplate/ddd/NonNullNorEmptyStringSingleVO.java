package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <VO>
 */
public abstract class NonNullNorEmptyStringSingleVO<VO extends NonNullNorEmptyStringSingleVO<VO>>
        extends NonNullSingleVO<NonNullNorEmptyStringSingleVO<VO>, String> {
    @Override
    protected ValidationResult validateMe() {
        ValidationResult result = super.validateMe();
        if (!result.isSatisfied()) return result;        
        return ValidationResult.of(!attribute.isEmpty());
    }
}
