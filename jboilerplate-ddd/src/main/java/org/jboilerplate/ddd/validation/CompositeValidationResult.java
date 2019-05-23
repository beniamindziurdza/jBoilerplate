package org.jboilerplate.ddd.validation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.jboilerplate.ddd.info.DomainInfo;

public class CompositeValidationResult implements ValidationResult {
        
    protected CompositeValidationResult(boolean isSatisfied, DomainInfo subject, List<ValidationResult> subresults, List<DomainInfo> failureReasons, List<DomainInfo> warnings ) {
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

    protected DomainInfo subject;
    @Override
    public Optional<DomainInfo> subject() {
        return Optional.ofNullable(subject);
    }    
    
    protected List<DomainInfo> failureReasons;
    @Override
    public List<DomainInfo> failureReasons() {
        return Collections.unmodifiableList(failureReasons);
    }

    protected List<DomainInfo> warnings;
    @Override
    public List<DomainInfo> warnings() {
        return Collections.unmodifiableList(warnings);
    }
    
    protected List<ValidationResult> subresults;
    @Override
    public List<ValidationResult> subresults() {
        return Collections.unmodifiableList(subresults);
    }

}
