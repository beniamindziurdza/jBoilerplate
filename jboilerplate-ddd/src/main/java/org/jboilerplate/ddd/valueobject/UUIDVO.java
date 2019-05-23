package org.jboilerplate.ddd.valueobject;

import java.util.UUID;

/**
 * 
 * @author Beniamin.Dziurdza
 * @param <voT>
 */
public abstract class UUIDVO<voT extends UUIDVO<voT>>
        extends NonNullVO<voT, UUID> {
    
    public static <voT extends UUIDVO<voT>> voT create(Class<voT> clazz) {       
       return NonNullVO.create(clazz, UUID.randomUUID());
    }
}
