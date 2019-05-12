package org.jboilerplate.ddd;

import java.util.ArrayList;
import java.util.List;


public class CompositeValidationResultBuilder {

    private boolean isSatisfied = true;
    private DomainMessage subject = null;
    private List<ValidationResult> subresults = new ArrayList<>();
    private List<DomainMessage> failureReasons = new ArrayList<>();
    private List<DomainMessage> warnings = new ArrayList<>();

    public CompositeValidationResultBuilder() {
    }
        
    protected <T> List<T> verifyNotNullAndHasNotNullElement(final List<T> list, final String argName) {
        if (list == null) throw new IllegalArgumentException(argName + " is null");
        if (list.contains(null)) throw new IllegalArgumentException(argName + " has null element");        
        return list;
    }
       
    public CompositeValidationResultBuilder appendFailureReason(final DomainMessage failureReason) {
        if (failureReason == null) throw new IllegalArgumentException("failureReason is null");
        failureReasons.add(failureReason);
        isSatisfied = false;
        return this;
    }
    
    public CompositeValidationResultBuilder appendWarning(final DomainMessage warning) {
        if (warning == null) throw new IllegalArgumentException("warning is null");
        warnings.add(warning);
        return this;
    }
        
    public CompositeValidationResultBuilder appendValidationResult(final ValidationResult validationResult) {
        if (validationResult == null) throw new IllegalArgumentException("validationResult is null");
        subresults.add(validationResult);
        isSatisfied &= validationResult.isSatisfied();
        return this;
    }
    
    public CompositeValidationResultBuilder setSubject(final DomainMessage subject) {
        this.subject = subject;
        return this;
    }

    public CompositeValidationResultBuilder setSubresults(final List<ValidationResult> subresults) {        
        this.subresults = verifyNotNullAndHasNotNullElement(subresults, "subresults");
        isSatisfied = this.failureReasons.size() > 0
                && subresults.stream().anyMatch(result -> !result.isSatisfied());
        return this;
    }

    public CompositeValidationResultBuilder setFailureReasons(final List<DomainMessage> failureReasons) {
        this.failureReasons = verifyNotNullAndHasNotNullElement(failureReasons, "failureReasons");
        if (this.failureReasons.size() > 0) isSatisfied = false;
        return this;
    }

    public CompositeValidationResultBuilder setWarnings(final List<DomainMessage> warnings) {
        this.warnings = verifyNotNullAndHasNotNullElement(warnings, "warnings");
        return this;
    }

    public CompositeValidationResult createValidationResult() {
        return new CompositeValidationResult(isSatisfied, subject, subresults, failureReasons, warnings);
    }
    
    public CompositeValidationResult forceIsSatisfiedAndCreateValidationResult(final boolean isSatisfied) {
        return new CompositeValidationResult(isSatisfied, subject, subresults, failureReasons, warnings);
    }
}
