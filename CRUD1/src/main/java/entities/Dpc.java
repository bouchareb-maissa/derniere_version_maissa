/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mac
 */
@Entity
@Table(name = "dpc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dpc.findAll", query = "SELECT d FROM Dpc d"),
    @NamedQuery(name = "Dpc.findById", query = "SELECT d FROM Dpc d WHERE d.id = :id"),
    @NamedQuery(name = "Dpc.findByDatesoumission", query = "SELECT d FROM Dpc d WHERE d.datesoumission = :datesoumission"),
    @NamedQuery(name = "Dpc.findByListefichiers", query = "SELECT d FROM Dpc d WHERE d.listefichiers = :listefichiers"),
    @NamedQuery(name = "Dpc.findByEtat", query = "SELECT d FROM Dpc d WHERE d.etat = :etat"),
    @NamedQuery(name = "Dpc.findByValidit\u00e9", query = "SELECT d FROM Dpc d WHERE d.validit\u00e9 = :validit\u00e9"),
    @NamedQuery(name = "Dpc.findByMotifderejet", query = "SELECT d FROM Dpc d WHERE d.motifderejet = :motifderejet")})
public class Dpc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datesoumission")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datesoumission;
    @Size(max = 50)
    @Column(name = "listefichiers")
    private String listefichiers;
    @Size(max = 2147483647)
    @Column(name = "etat")
    private String etat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validit\u00e9")
    private boolean validité;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 220)
    @Column(name = "motifderejet")
    private String motifderejet;
    @JoinColumn(name = "patient", referencedColumnName = "nss")
    @ManyToOne(optional = false)
    private Patient patient;
    @JoinColumn(name = "id_structure", referencedColumnName = "id")
    @ManyToOne
    private Structure idStructure;

    public Dpc() {
    }

    public Dpc(Integer id) {
        this.id = id;
    }

    public Dpc(Integer id, Date datesoumission, boolean validité, String motifderejet) {
        this.id = id;
        this.datesoumission = datesoumission;
        this.validité = validité;
        this.motifderejet = motifderejet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatesoumission() {
        return datesoumission;
    }

    public void setDatesoumission(Date datesoumission) {
        this.datesoumission = datesoumission;
    }

    public String getListefichiers() {
        return listefichiers;
    }

    public void setListefichiers(String listefichiers) {
        this.listefichiers = listefichiers;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public boolean getValidité() {
        return validité;
    }

    public void setValidité(boolean validité) {
        this.validité = validité;
    }

    public String getMotifderejet() {
        return motifderejet;
    }

    public void setMotifderejet(String motifderejet) {
        this.motifderejet = motifderejet;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
        if (!(object instanceof Dpc)) {
            return false;
        }
        Dpc other = (Dpc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dpc[ id=" + id + " ]";
    }
    
}
