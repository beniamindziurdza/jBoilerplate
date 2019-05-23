package org.jboilerplate.ddd.validation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.jboilerplate.ddd.info.DomainInfo;

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
    public Optional<DomainInfo> subject() {
        return Optional.empty();
    }
        
    @Override
    public List<DomainInfo> failureReasons() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<DomainInfo> warnings() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<ValidationResult> subresults() {
        return Collections.EMPTY_LIST;
    }

}
