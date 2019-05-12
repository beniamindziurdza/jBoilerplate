package org.jboilerplate.ddd;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CompositeValidationResult implements ValidationResult {
        
    protected CompositeValidationResult(boolean isSatisfied, DomainMessage subject, List<ValidationResult> subresults, List<DomainMessage> failureReasons, List<DomainMessage> warnings ) {
        this.isSatisfied = isSatisfied;
        this.subject = subject;
        this.failureReasons = failureReasons;
        this.warnings = warnings;
        this.subresults = subresults;
    }     
    
    protected Boolean isSatisfied = false;   
    @Override
    public boolean isSatisfied() {
        return isSatisfied;
    }

    protected DomainMessage subject;
    @Override
    public Optional<DomainMessage> subject() {
        return Optional.ofNullable(subject);
    }    
    
    protected List<DomainMessage> failureReasons;
    @Override
    public List<DomainMessage> failureReasons() {
        return Collections.unmodifiableList(failureReasons);
    }

    protected List<DomainMessage> warnings;
    @Override
    public List<DomainMessage> warnings() {
        return Collections.unmodifiableList(warnings);
    }
    
    protected List<ValidationResult> subresults;
    @Override
    public List<ValidationResult> subresults() {
        return Collections.unmodifiableList(subresults);
    }

}
