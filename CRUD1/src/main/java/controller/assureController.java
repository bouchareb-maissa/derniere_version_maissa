/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.Assure;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.time.Clock.system;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.AssureFacade;

/**
 *
 * @author mac
 */
@Named(value = "assureController")
@SessionScoped
public class assureController implements Serializable {
    Integer NSS;
    String mdp;
    
    private Boolean cnx = true;

    public Boolean getCnx() {
        return cnx;
    }

    public void setCnx(Boolean cnx) {
        this.cnx = cnx;
    }
    
    
   public String verify(){
         if (assure.getNss()==1 ||assure.getNss()==4 ) {
              System.out.println("if");
            return "accueil";
        } 
        else{
             error();
             System.out.println("else");
            return "loginAssuré";
        }
         
        
        
    }
  
    public Integer getNSS() {
        return NSS;
    }

    public void setNSS(Integer NSS) {
        this.NSS = NSS;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
     public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "numéro de sécurité sociale ou mot de passe incorrect", "numéro de sécurité sociale ou mot de passe incorrect"));
          }

    @EJB
    private AssureFacade assureFacade;
    private Assure assure = new Assure();

    public AssureFacade getAssureFacade() {
        return assureFacade;
    }

    public void setAssureFacade(AssureFacade assureFacade) {
        this.assureFacade = assureFacade;
    }

    public Assure getAssure() {
        return assure;
    }

    public void setAssure(Assure assure) {
        this.assure = assure;
    }

     
    /**
     * Creates a new instance of assureController
     */
    public assureController() {
    }
    
}
