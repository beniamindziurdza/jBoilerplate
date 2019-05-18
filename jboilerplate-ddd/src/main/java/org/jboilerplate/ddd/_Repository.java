package org.jboilerplate.ddd;

import java.util.List;

/**
 *
 * @author Beniamin.Dziurdza
 */
public class _Repository implements ICanFindById<_Entity, _Identity>, ICanFindAll<_Entity> {

    @Override
    public _Entity find(_Identity identity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<_Entity> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
