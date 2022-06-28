/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "assure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assure.findAll", query = "SELECT a FROM Assure a"),
    @NamedQuery(name = "Assure.findById", query = "SELECT a FROM Assure a WHERE a.id = :id"),
    @NamedQuery(name = "Assure.findByNss", query = "SELECT a FROM Assure a WHERE a.nss = :nss"),
    @NamedQuery(name = "Assure.findByMdp", query = "SELECT a FROM Assure a WHERE a.mdp = :mdp")})
public class Assure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nss")
    private int nss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "mdp")
    private String mdp;

    public Assure() {
    }

    public Assure(Integer id) {
        this.id = id;
    }

    public Assure(Integer id, int nss, String mdp) {
        this.id = id;
        this.nss = nss;
        this.mdp = mdp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
        if (!(object instanceof Assure)) {
            return false;
        }
        Assure other = (Assure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Assure[ id=" + id + " ]";
    }
    
}
