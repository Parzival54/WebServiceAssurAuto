/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.bean;

import entite.Vehicule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author merguez
 */
@Stateless
public class VehiculeFacade extends AbstractFacade<Vehicule> {

    @PersistenceContext(unitName = "SOAPAssurAutoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculeFacade() {
        super(Vehicule.class);
    }
    
}
