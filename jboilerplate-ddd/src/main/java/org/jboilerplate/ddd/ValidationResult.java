package org.jboilerplate.ddd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult implements IValidationResult {
    
    public ValidationResult(boolean isSatisfied) {
        this.isSatisfied = isSatisfied;
        this.failureReasons = new ArrayList<>();
        this.warnings = new ArrayList<>();
    }
    
    public ValidationResult(boolean isSatisfied, List<DomainMessage> failureReasons ) {
        this.isSatisfied = isSatisfied;
        this.failureReasons = failureReasons;
        this.warnings = new ArrayList<>();
    }    
    
    public ValidationResult(boolean isSatisfied, List<DomainMessage> failureReasons, List<DomainMessage> warnings ) {
        this.isSatisfied = isSatisfied;
        this.failureReasons = failureReasons;
        this.warnings = warnings;
    }        
    
    protected Boolean isSatisfied;    
    @Override
    public boolean isSatisfied() {
        return isSatisfied;
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
    
    /*  
    public void appendFailureReason(DomainMessage failureReason) {       
        failureReasons.add(failureReason);
    }
    
    public void appendWarning(DomainMessage warning) {                
        warnings.add(warning);
    }    
    */
}
