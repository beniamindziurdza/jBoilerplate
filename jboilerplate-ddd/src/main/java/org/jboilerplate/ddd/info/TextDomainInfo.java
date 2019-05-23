package org.jboilerplate.ddd.info;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class TextDomainInfo implements DomainInfo {
    
    protected String text;
    
    public String text() {
        return text;
    }
    
    public TextDomainInfo(String text) {
        this.text = text;
    }
    
}
