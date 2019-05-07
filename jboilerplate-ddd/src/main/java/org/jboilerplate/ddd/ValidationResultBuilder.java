package org.jboilerplate.ddd;

import java.util.ArrayList;
import java.util.List;


public class ValidationResultBuilder {

    private boolean isSatisfied;
    private List<DomainMessage> failureReasons;
    private List<DomainMessage> warnings;

    public ValidationResultBuilder() {
    }

    public ValidationResultBuilder setIsSatisfied(boolean isSatisfied) {
        this.isSatisfied = isSatisfied;
        return this;
    }

    public ValidationResultBuilder setFailureReasons(List<DomainMessage> failureReasons) {
        this.failureReasons = failureReasons;
        return this;
    }

    public ValidationResultBuilder setWarnings(List<DomainMessage> warnings) {
        this.warnings = warnings;
        return this;
    }

    public ValidationResult createValidationResult() {
        return new ValidationResult(isSatisfied, failureReasons, warnings);
    }
    
    public void appendValidationResult(IValidationResult validationResult) {
        this.isSatisfied &= validationResult.isSatisfied();
        if (failureReasons == null) failureReasons = new ArrayList<>();
        if (warnings == null) warnings = new ArrayList<>();
        failureReasons.addAll(validationResult.failureReasons());
        warnings.addAll(validationResult.warnings());
    }
    
}
