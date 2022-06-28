/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByNss", query = "SELECT p FROM Patient p WHERE p.nss = :nss"),
    @NamedQuery(name = "Patient.findByNom", query = "SELECT p FROM Patient p WHERE p.nom = :nom"),
    @NamedQuery(name = "Patient.findByPrenom", query = "SELECT p FROM Patient p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Patient.findByDatenaissance", query = "SELECT p FROM Patient p WHERE p.datenaissance = :datenaissance"),
    @NamedQuery(name = "Patient.findByAdresse", query = "SELECT p FROM Patient p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Patient.findByTelephone", query = "SELECT p FROM Patient p WHERE p.telephone = :telephone")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nss")
    private Integer nss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "datenaissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 20)
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(mappedBy = "idPatient")
    private List<Trajet> trajetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Dpc> dpcList;
    @JoinColumn(name = "id_operateur", referencedColumnName = "id")
    @ManyToOne
    private Operateur idOperateur;
    @OneToMany(mappedBy = "idPatient")
    private List<Reclamation> reclamationList;

    public Patient() {
    }

    public Patient(Integer nss) {
        this.nss = nss;
    }

    public Patient(Integer nss, String nom, String prenom, String adresse) {
        this.nss = nss;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Integer getNss() {
        return nss;
    }

    public void setNss(Integer nss) {
        this.nss = nss;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public List<Trajet> getTrajetList() {
        return trajetList;
    }

    public void setTrajetList(List<Trajet> trajetList) {
        this.trajetList = trajetList;
    }

    @XmlTransient
    public List<Dpc> getDpcList() {
        return dpcList;
    }

    public void setDpcList(List<Dpc> dpcList) {
        this.dpcList = dpcList;
    }

    public Operateur getIdOperateur() {
        return idOperateur;
    }

    public void setIdOperateur(Operateur idOperateur) {
        this.idOperateur = idOperateur;
    }

    @XmlTransient
    public List<Reclamation> getReclamationList() {
        return reclamationList;
    }

    public void setReclamationList(List<Reclamation> reclamationList) {
        this.reclamationList = reclamationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nss != null ? nss.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.nss == null && other.nss != null) || (this.nss != null && !this.nss.equals(other.nss))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Patient[ nss=" + nss + " ]";
    }
    
}
