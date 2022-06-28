/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.Patient;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.PatientFacade;

/**
 *
 * @author mac
 */
@Named(value = "patientController")
@SessionScoped
public class patientController implements Serializable {
    @EJB
    private PatientFacade patientFacade;
    private Patient patient = new Patient();

    /**
     * Creates a new instance of patientController
     */
    public patientController() {
    }
    
     public List<Patient> findAll() {
       
        return this.patientFacade.findAll();
        }
    
}
