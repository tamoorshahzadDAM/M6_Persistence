/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@Table(name = "VEHICLES")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idVehicle")
    private Long idVehicle;
    
    
    @Column(name = "matricula", length = 7, unique = true, nullable = false)
    @IndexColumn(name="indexMatricula")
    private String matricula;
    
    @Column(name = "marcaModel")
    private String marcaModel;
    
    @Column(name = "anyFabricacio")
    private int anyFabricacio;
    
    @Basic(fetch = FetchType.LAZY)
    //@OneToMany
    @Column(name = "propietari")
    //@Basic(fetch = FetchType.LAZY)
    public Client propietari;
    
    @OneToOne(mappedBy = "vehicle")
    private Polissa polissa;

    public Vehicle(Long idVehivle, String matricula, String marcaModel, int anyFabricacio, Client propietari, Polissa polissa) {
        this.idVehicle = idVehivle;
        this.matricula = matricula;
        this.marcaModel = marcaModel;
        this.anyFabricacio = anyFabricacio;
        this.propietari = propietari;
        this.polissa = polissa;
    }

    public Vehicle() {
    }

    public Long getIdVehivle() {
        return idVehicle;
    }

    public void setIdVehivle(Long idVehivle) {
        this.idVehicle = idVehivle;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarcaModel() {
        return marcaModel;
    }

    public void setMarcaModel(String marcaModel) {
        this.marcaModel = marcaModel;
    }

    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }

    public Client getPropietari() {
        return propietari;
    }

    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }
    
    
    
    
    
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicle != null ? idVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.idVehicle == null && other.idVehicle != null) || (this.idVehicle != null && !this.idVehicle.equals(other.idVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "idVehivle=" + idVehicle + ", matricula=" + matricula + ", marcaModel=" + marcaModel + ", anyFabricacio=" + anyFabricacio + ", propietari=" + propietari + '}';
    }

   
    
}
