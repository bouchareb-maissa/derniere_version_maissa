/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "operateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operateur.findAll", query = "SELECT o FROM Operateur o"),
    @NamedQuery(name = "Operateur.findById", query = "SELECT o FROM Operateur o WHERE o.id = :id"),
    @NamedQuery(name = "Operateur.findByNom", query = "SELECT o FROM Operateur o WHERE o.nom = :nom"),
    @NamedQuery(name = "Operateur.findByAdresse", query = "SELECT o FROM Operateur o WHERE o.adresse = :adresse"),
    @NamedQuery(name = "Operateur.findByWilaya", query = "SELECT o FROM Operateur o WHERE o.wilaya = :wilaya"),
    @NamedQuery(name = "Operateur.findByTelephone", query = "SELECT o FROM Operateur o WHERE o.telephone = :telephone"),
    @NamedQuery(name = "Operateur.findByEmail", query = "SELECT o FROM Operateur o WHERE o.email = :email"),
    @NamedQuery(name = "Operateur.findByListefichier", query = "SELECT o FROM Operateur o WHERE o.listefichier = :listefichier"),
    @NamedQuery(name = "Operateur.findByNbaversittement", query = "SELECT o FROM Operateur o WHERE o.nbaversittement = :nbaversittement"),
    @NamedQuery(name = "Operateur.findByNbsignalement", query = "SELECT o FROM Operateur o WHERE o.nbsignalement = :nbsignalement"),
    @NamedQuery(name = "Operateur.findByNbvehicule", query = "SELECT o FROM Operateur o WHERE o.nbvehicule = :nbvehicule"),
    @NamedQuery(name = "Operateur.findByScore", query = "SELECT o FROM Operateur o WHERE o.score = :score")})
public class Operateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "wilaya")
    private String wilaya;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "listefichier")
    private String listefichier;
    @Column(name = "nbaversittement")
    private Integer nbaversittement;
    @Column(name = "nbsignalement")
    private Integer nbsignalement;
    @Column(name = "nbvehicule")
    private Integer nbvehicule;
    @Column(name = "score")
    private Integer score;
    @OneToMany(mappedBy = "idOperateur")
    private List<Trajet> trajetList;
    @OneToMany(mappedBy = "idOperateur")
    private List<Patient> patientList;
    @OneToMany(mappedBy = "idOperateur")
    private List<Reclamation> reclamationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operateur")
    private List<Controle> controleList;

    public Operateur() {
    }

    public Operateur(Integer id) {
        this.id = id;
    }

    public Operateur(Integer id, String nom, String adresse, String wilaya, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.wilaya = wilaya;
        this.telephone = telephone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getListefichier() {
        return listefichier;
    }

    public void setListefichier(String listefichier) {
        this.listefichier = listefichier;
    }

    public Integer getNbaversittement() {
        return nbaversittement;
    }

    public void setNbaversittement(Integer nbaversittement) {
        this.nbaversittement = nbaversittement;
    }

    public Integer getNbsignalement() {
        return nbsignalement;
    }

    public void setNbsignalement(Integer nbsignalement) {
        this.nbsignalement = nbsignalement;
    }

    public Integer getNbvehicule() {
        return nbvehicule;
    }

    public void setNbvehicule(Integer nbvehicule) {
        this.nbvehicule = nbvehicule;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @XmlTransient
    public List<Trajet> getTrajetList() {
        return trajetList;
    }

    public void setTrajetList(List<Trajet> trajetList) {
        this.trajetList = trajetList;
    }

    @XmlTransient
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @XmlTransient
    public List<Reclamation> getReclamationList() {
        return reclamationList;
    }

    public void setReclamationList(List<Reclamation> reclamationList) {
        this.reclamationList = reclamationList;
    }

    @XmlTransient
    public List<Controle> getControleList() {
        return controleList;
    }

    public void setControleList(List<Controle> controleList) {
        this.controleList = controleList;
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
        if (!(object instanceof Operateur)) {
            return false;
        }
        Operateur other = (Operateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operateur[ id=" + id + " ]";
    }
    
}
