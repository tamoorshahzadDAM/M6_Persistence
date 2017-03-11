/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@NamedQueries({
    //@NamedQuery(name = Polissa.Polissa_Prenedor, query = "SELECT p FROM Polissa p WHERE p.prenedor=:Prenedor"),
    //@NamedQuery(name = Polissa.Polissa_Vehicle, query = "SELECT p FROM Polissa p WHERE p.vehicle:Vehicle")
    @NamedQuery(name="Cerca_Polissa_Client", query="SELECT p FROM Polissa p WHERE p.cliente=:cliente")
})
@Table(name = "M6UF2_POLISSA")
public class Polissa implements Serializable {

    
    //public static final String Polissa_Prenedor = "PolissaPrenedor";
    //public static final String Polissa_Vehicle = "PolissaVehicle";
    public static final String Cerca_Polissa_Client = "CercaPolissaClient";
    
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPolissa")
    private int idPolissa;

    @Column(name = "numPolissa", length = 10)
    private String numPolissa;

    @Column(name = "prenedor", nullable = false)
    @IndexColumn(name = "indexPrenedor")
    @Basic(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne
    //@JoinColumn(name="propietariPolissa")
    private Client prenedor;

    //@Column(name = "vehicle", nullable = false)
    //@Basic(fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;
    
    @ManyToOne (fetch = FetchType.LAZY) 
    @JoinColumn(name = "idClient")
    private Client cliente;

    @Column(name = "dataInici", nullable = false)
    private Calendar dataInici;

    @Column(name = "dataFi", nullable = false)
    private Calendar dataFi;

    @Column(name = "tipuPolissa", nullable = false)
    //@ElementCollection
    //@Enumerated(EnumType.STRING)
    private Polissa tipuPolissa;

    
    @Column(name = "prima")
    private Asseguradora prima;

    public Polissa(int idPolissa, String numPolissa, Client prenedor, Vehicle vehicle, Calendar dataInici, Calendar dataFi, Polissa tipuPolissa, Asseguradora prima) {
        this.idPolissa = idPolissa;
        this.numPolissa = numPolissa;
        this.prenedor = prenedor;
        this.vehicle = vehicle;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipuPolissa = tipuPolissa;
        this.prima = prima;
    }

    public Polissa() {
    }

    public int getIdPolissa() {
        return idPolissa;
    }

    public void setIdPolissa(int idPolissa) {
        this.idPolissa = idPolissa;
    }

    public String getNumPolissa() {
        return numPolissa;
    }

    public void setNumPolissa(String numPolissa) {
        this.numPolissa = numPolissa;
    }

    public Client getPrenedor() {
        return prenedor;
    }

    public void setPrenedor(Client prenedor) {
        this.prenedor = prenedor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Calendar getDataInici() {
        return dataInici;
    }

    public void setDataInici(Calendar dataInici) {
        this.dataInici = dataInici;
    }

    public Calendar getDataFi() {
        return dataFi;
    }

    public void setDataFi(Calendar dataFi) {
        this.dataFi = dataFi;
    }

    public Polissa getTipuPolissa() {
        return tipuPolissa;
    }

    public void setTipuPolissa(Polissa tipuPolissa) {
        this.tipuPolissa = tipuPolissa;
        
    }

    public Asseguradora getPrima() {
        return prima;
    }

    public void setPrima(Asseguradora prima) {
        this.prima = prima;
    }
    
    
    
    
    
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPolissa != null ? numPolissa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polissa)) {
            return false;
        }
        Polissa other = (Polissa) object;
        if ((this.numPolissa == null && other.numPolissa != null) || (this.numPolissa != null && !this.numPolissa.equals(other.numPolissa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "idPolissa=" + idPolissa + ", numPolissa=" + numPolissa + ", prenedor=" + prenedor + ", vehicle=" + vehicle + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipuPolissa=" + tipuPolissa + ", prima=" + prima + '}';
    }

    

}
