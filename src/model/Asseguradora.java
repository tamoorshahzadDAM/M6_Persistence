/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
public class Asseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAsseguradora", nullable = false)
    private Long idAsseg;
    
    
    @Column(name = "nomAsseguradora", length = 100, nullable = false)
    private String nomasseg;

    @Column(name = "nifAsseguradora")
    private String nifAsseg;

    public Asseguradora(Long idAsseg, String nomasseg, String nifAsseg) {
        this.idAsseg = idAsseg;
        this.nomasseg = nomasseg;
        this.nifAsseg = nifAsseg;
    }

    public Long getIdAsseg() {
        return idAsseg;
    }

    public void setIdAsseg(Long idAsseg) {
        this.idAsseg = idAsseg;
    }

    public String getNomasseg() {
        return nomasseg;
    }

    public void setNomasseg(String nomasseg) {
        this.nomasseg = nomasseg;
    }

    public String getNifAsseg() {
        return nifAsseg;
    }

    public void setNifAsseg(String nifAsseg) {
        this.nifAsseg = nifAsseg;
    }

    
    
    
    
    
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsseg != null ? idAsseg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idAsseg fields are not set
        if (!(object instanceof Asseguradora)) {
            return false;
        }
        Asseguradora other = (Asseguradora) object;
        if ((this.idAsseg == null && other.idAsseg != null) || (this.idAsseg != null && !this.idAsseg.equals(other.idAsseg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asseguradora{" + "idAsseg=" + idAsseg + ", nomasseg=" + nomasseg + ", nifAsseg=" + nifAsseg + '}';
    }

    
    
}
