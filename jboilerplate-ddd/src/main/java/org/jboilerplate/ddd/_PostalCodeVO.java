package org.jboilerplate.ddd;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class _PostalCodeVO extends MissingCapableNonNullNorEmptyStringSingleVO<_PostalCodeVO> {

    @Override
    public _PostalCodeVO missing() {
        return _Missing.MISSING;
    }
    
    public static final _Missing MISSING = new _Missing();
       
    private static class _Missing extends _PostalCodeVO {        
    }
    
}
