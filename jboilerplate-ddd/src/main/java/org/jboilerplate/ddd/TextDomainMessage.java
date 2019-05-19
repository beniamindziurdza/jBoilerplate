package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class TextDomainMessage implements DomainMessage {
    
    protected String text;
    
    public String text() {
        return text;
    }
    
    public TextDomainMessage(String text) {
        this.text = text;
    }
    
}
