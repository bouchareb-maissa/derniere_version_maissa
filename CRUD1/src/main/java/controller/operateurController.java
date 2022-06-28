/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.Operateur;
import entities.Reclamation;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.OperateurFacade;
import model.ReclamationFacade;

/**
 *
 * @author mac
 */
@Named(value = "operateurController")
@SessionScoped
public class operateurController implements Serializable {

     @EJB
    private OperateurFacade operateurFacade;
    private Operateur operateur = new Operateur();

    public OperateurFacade getOperateurFacade() {
        return operateurFacade;
    }

    public void setOperateurFacade(OperateurFacade operateurFacade) {
        this.operateurFacade = operateurFacade;
    }

    public Operateur getOperateur() {
        return operateur;
    }

    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }
    
    /**
     * Creates a new instance of operateurController
     */
    public operateurController() {
    }
    public List<Operateur> findAll() {
       
        return this.operateurFacade.findAll();
        }
    
}
