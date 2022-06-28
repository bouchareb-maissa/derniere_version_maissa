/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.Operateur;
import entities.Patient;
import entities.Reclamation;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import model.OperateurFacade;
import model.PatientFacade;
import model.ReclamationFacade;

/**
 *
 * @author mac
 */
@Named(value = "reclamationController")
@SessionScoped
public class reclamationController implements Serializable {

    @EJB
    private ReclamationFacade reclamationFacade;
    private Reclamation reclamation = new Reclamation();
     private List<SelectItem> patientList;

    private Patient p = new Patient();
    private Operateur op = new Operateur();

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public Operateur getOp() {
        return op;
    }

    public void setOp(Operateur op) {
        this.op = op;
    }

    public PatientFacade getPatientFacade() {
        return patientFacade;
    }

    public void setPatientFacade(PatientFacade patientFacade) {
        this.patientFacade = patientFacade;
    }

    public OperateurFacade getOperateurFacade() {
        return operateurFacade;
    }

    public void setOperateurFacade(OperateurFacade operateurFacade) {
        this.operateurFacade = operateurFacade;
    }

    public List<SelectItem> getOperateurList() {
        return operateurList;
    }

    public void setOperateurList(List<SelectItem> operateurList) {
        this.operateurList = operateurList;
    }
    
   
    public ReclamationFacade getReclamationFacade() {
        return reclamationFacade;
    }

    public void setReclamationFacade(ReclamationFacade reclamationFacade) {
        this.reclamationFacade = reclamationFacade;
    }

    public List<SelectItem> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<SelectItem> patientList) {
        this.patientList = patientList;
    }

    
    
    public Reclamation getReclamation() {
        return reclamation;
    }

    /**
     * Creates a new instance of reclamationController
     */
    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
    }

    public reclamationController() {
    }
    public List<Reclamation> findAll() {
       
        return this.reclamationFacade.findAll();
        }
    public String insert() {
           System.out.println("dkhoul");
        System.out.println("OPERATEURUUUR" + this.op.getNom());
        reclamation.setIdOperateur(op);
        reclamation.setIdPatient(p);
        System.out.println("INSEEEEEEEEEEEEEEEEERT");
        this.op = new Operateur();
        this.p = new Patient();
        this.reclamationFacade.create(reclamation);
        this.reclamation= new Reclamation(); 
        return "index";
        
    }
     @EJB
     private PatientFacade patientFacade;
     
     @EJB
     private OperateurFacade operateurFacade;
     private List<SelectItem> operateurList;
     
    
    @PostConstruct
    public void initBean() {

        patientList = new ArrayList<>();
         this.reclamationFacade.create(reclamation);
        //   sessionFacade = new SessionFacade();
        System.out.println("HEEEEEEEEEEEEEEEEERE");
        List<Patient> list1 = this.patientFacade.findAll();
        for (Patient p : list1) {
            patientList.add(new SelectItem(p.getNss(), p.getNom()));
        }
        operateurList = new ArrayList<>();
         List<Operateur> list2 = this.operateurFacade.findAll();
        for (Operateur op : list2) {
            operateurList.add(new SelectItem(op.getId(), op.getNom()));
        }
        
    }

    
     public String delete(Reclamation reclamation) {
        System.out.println("sup");
       this.reclamationFacade.remove(reclamation);
        return "index";
        }
    
}
