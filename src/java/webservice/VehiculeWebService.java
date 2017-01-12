/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import entite.Vehicule;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import session.bean.VehiculeFacade;

/**
 *
 * @author merguez
 */
@WebService(serviceName = "VehiculeWebService")
public class VehiculeWebService {

    @EJB
    private VehiculeFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Vehicule entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Vehicule entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Vehicule entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Vehicule find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Vehicule> findAll() {
        return ejbRef.findAll();
    }
    
    @WebMethod(operationName = "findAllMarque")
    public Set<String> findAllMarque() {
        List<Vehicule> vehicules = ejbRef.findAll();
        SortedSet<String> marques = new TreeSet<>();
        vehicules.forEach((vehicule) -> {
            marques.add(vehicule.getMarque());
        });
        return marques;
    }
    
    @WebMethod(operationName = "findAllModeleByMarque")
    public Set<String> findAllModeleByMarque(String marque) {
        List<Vehicule> vehicules = ejbRef.findAll();
        SortedSet<String> modeles = new TreeSet<>();
        vehicules.forEach((vehicule) -> {
            if (vehicule.getMarque().equals(marque)){
            modeles.add(vehicule.getModele());
            }
        });
        return modeles;
    }
    
    @WebMethod(operationName = "findAllVersionByModele")
    public Set<String> findAllVersionByModele(String marque, String modele) {
        List<Vehicule> vehicules = ejbRef.findAll();
        SortedSet<String> versions = new TreeSet<>();
        vehicules.forEach((vehicule) -> {
            if (vehicule.getMarque().equals(marque) && vehicule.getModele().equals(modele)){
            versions.add((vehicule.getMarque() + " " + vehicule.getModele() + " " + vehicule.getVersion()).trim());
            }
        });
        return versions;
    }

    @WebMethod(operationName = "findRange")
    public List<Vehicule> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
