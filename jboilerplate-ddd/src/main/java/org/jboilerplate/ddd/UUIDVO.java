package org.jboilerplate.ddd;

import java.util.UUID;

/**
 * 
 * @author Beniamin.Dziurdza
 * @param <VO>
 */
public abstract class UUIDVO<VO extends UUIDVO<VO>>
        extends NonNullVO<VO, UUID> {
    
    public static <VO extends UUIDVO<VO>> VO create(Class<VO> clazz) {       
       return NonNullVO.create(clazz, UUID.randomUUID());
    }
}
