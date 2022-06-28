/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "trajet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trajet.findAll", query = "SELECT t FROM Trajet t"),
    @NamedQuery(name = "Trajet.findById", query = "SELECT t FROM Trajet t WHERE t.id = :id"),
    @NamedQuery(name = "Trajet.findByDestination", query = "SELECT t FROM Trajet t WHERE t.destination = :destination"),
    @NamedQuery(name = "Trajet.findByDistance", query = "SELECT t FROM Trajet t WHERE t.distance = :distance"),
    @NamedQuery(name = "Trajet.findByTempsattente", query = "SELECT t FROM Trajet t WHERE t.tempsattente = :tempsattente"),
    @NamedQuery(name = "Trajet.findByChangementiteneraire", query = "SELECT t FROM Trajet t WHERE t.changementiteneraire = :changementiteneraire"),
    @NamedQuery(name = "Trajet.findByMotoifchangement", query = "SELECT t FROM Trajet t WHERE t.motoifchangement = :motoifchangement"),
    @NamedQuery(name = "Trajet.findByTrajetdouteux", query = "SELECT t FROM Trajet t WHERE t.trajetdouteux = :trajetdouteux"),
    @NamedQuery(name = "Trajet.findByTrajetvalide", query = "SELECT t FROM Trajet t WHERE t.trajetvalide = :trajetvalide")})
public class Trajet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distance")
    private float distance;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tempsattente")
    private Double tempsattente;
    @Column(name = "changementiteneraire")
    private Boolean changementiteneraire;
    @Size(max = 200)
    @Column(name = "motoifchangement")
    private String motoifchangement;
    @Column(name = "trajetdouteux")
    private Boolean trajetdouteux;
    @Column(name = "trajetvalide")
    private Boolean trajetvalide;
    @JoinColumn(name = "id_facture", referencedColumnName = "id")
    @ManyToOne
    private Facture idFacture;
    @JoinColumn(name = "id_operateur", referencedColumnName = "id")
    @ManyToOne
    private Operateur idOperateur;
    @JoinColumn(name = "id_patient", referencedColumnName = "nss")
    @ManyToOne
    private Patient idPatient;
    @JoinColumn(name = "id_structure", referencedColumnName = "id")
    @ManyToOne
    private Structure idStructure;

    public Trajet() {
    }

    public Trajet(Integer id) {
        this.id = id;
    }

    public Trajet(Integer id, String destination, float distance) {
        this.id = id;
        this.destination = destination;
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Double getTempsattente() {
        return tempsattente;
    }

    public void setTempsattente(Double tempsattente) {
        this.tempsattente = tempsattente;
    }

    public Boolean getChangementiteneraire() {
        return changementiteneraire;
    }

    public void setChangementiteneraire(Boolean changementiteneraire) {
        this.changementiteneraire = changementiteneraire;
    }

    public String getMotoifchangement() {
        return motoifchangement;
    }

    public void setMotoifchangement(String motoifchangement) {
        this.motoifchangement = motoifchangement;
    }

    public Boolean getTrajetdouteux() {
        return trajetdouteux;
    }

    public void setTrajetdouteux(Boolean trajetdouteux) {
        this.trajetdouteux = trajetdouteux;
    }

    public Boolean getTrajetvalide() {
        return trajetvalide;
    }

    public void setTrajetvalide(Boolean trajetvalide) {
        this.trajetvalide = trajetvalide;
    }

    public Facture getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Facture idFacture) {
        this.idFacture = idFacture;
    }

    public Operateur getIdOperateur() {
        return idOperateur;
    }

    public void setIdOperateur(Operateur idOperateur) {
        this.idOperateur = idOperateur;
    }

    public Patient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    public Structure getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(Structure idStructure) {
        this.idStructure = idStructure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trajet)) {
            return false;
        }
        Trajet other = (Trajet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Trajet[ id=" + id + " ]";
    }
    
}
