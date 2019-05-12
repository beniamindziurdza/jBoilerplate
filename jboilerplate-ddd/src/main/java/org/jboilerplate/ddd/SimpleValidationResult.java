package org.jboilerplate.ddd;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SimpleValidationResult implements ValidationResult {

    public static final SimpleValidationResult SATISFIED = new SimpleValidationResult(true);
    public static final SimpleValidationResult NOT_SATISFIED = new SimpleValidationResult(false);
        
    protected boolean isSatisfied;
        
    public SimpleValidationResult(boolean isSatisfied) {
        this.isSatisfied = isSatisfied;
    }
    
    @Override
    public boolean isSatisfied() {
        return isSatisfied;
    }

    @Override
    public Optional<DomainMessage> subject() {
        return Optional.empty();
    }
        
    @Override
    public List<DomainMessage> failureReasons() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<DomainMessage> warnings() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ValidationResult> subresults() {
        return Collections.EMPTY_LIST;
    }

}
