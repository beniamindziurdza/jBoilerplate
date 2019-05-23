package org.jboilerplate.ddd.info;

import java.io.Serializable;

/**
 *
 * @author Beniamin.Dziurdza
 * 
 * Holds (possibly renderable to user or API client) domain information.
 * Used by ValidationResult and DomainException to keep appriopriate message.
 * Can be used in domain API or application service API.
 * 
 */
public interface DomainInfo extends Serializable {
    
}
