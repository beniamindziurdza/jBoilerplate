package org.jboilerplate.example;

import org.jboilerplate.ddd.VO;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class _PostalCodeVOTest {
    
    public void create() {
        _PostalCodeVO vo1 = VO.create(_PostalCodeVO.class, "01-001");

        _PostalCodeVO vo2 = _PostalCodeVO.createOrGetMissing(_PostalCodeVO.class, null);
        
        _PostalCodeVO missing = _PostalCodeVO.MISSING;
        
        _PostalCodeVO.createOrGetMissing(_PostalCodeVO.class, null);
        
    }
    
}
