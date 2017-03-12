/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@NamedQueries({
    //Queries
    //@NamedQuery(name="cercaClient", query="SELECT c FROM Client c WHERE c.idClient:id"),
    //@NamedQuery(name="cercaVehicle", query="SELECT c FROM Vehicle c WHERE c.idVehicle:id"),
    @NamedQuery(name = "cercaVehicleMat", query = "Select v FROM Vehicle v WHERE v.matricula=:matricula")
})
@Table(name = "VEHICLES")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    //Id de vehicle
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idVehicle")
    private Long idVehicle;
    
    //Columna para matricula, que indexa
    @Column(name = "matricula", length = 7, unique = true, nullable = false)
    @IndexColumn(name="indexMatricula")
    private String matricula;
    
    //Columna pra marca y modelo
    @Column(name = "marcaModel")
    private String marcaModel;
    
    //Columna para ano de fabricacion
    @Column(name = "anyFabricacio")
    private int anyFabricacio;
    
    //Relacion de muchos a uno, junta con columna de idClient.
    //@ManyToOne(cascade=CascadeType.ALL)
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idClient")
    private Client propietari;
    
    //Ralacion de uno a uno, 
    @OneToOne(mappedBy = "vehicle")
    private Polissa polissa;

    /**
     * Constructor de vehicle
     * @param matricula
     * @param marcaModel
     * @param anyFabricacio
     * @param propietari
     * @param polissa 
     */
    public Vehicle( String matricula, String marcaModel, int anyFabricacio, Client propietari, Polissa polissa) {
        this.matricula = matricula;
        this.marcaModel = marcaModel;
        this.anyFabricacio = anyFabricacio;
        this.propietari = propietari;
        this.polissa = polissa;
    }

    /**
     * Constructor vacio
     */
    public Vehicle() {
    }

    /**
     * getter de id de vehicle
     * @return 
     */
    public Long getIdVehivle() {
        return idVehicle;
    }

    /**
     * Setter de id de vehicle
     * @return 
     */
    public void setIdVehivle(Long idVehivle) {
        this.idVehicle = idVehivle;
    }

    /**
     * getter de matricula de vehicle
     * @return 
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Setter de matricula de vehicle
     * @return 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * getter de marca y modelo  de vehicle
     * @return 
     */
    public String getMarcaModel() {
        return marcaModel;
    }

    /**
     * Setter de marca y modelo  de vehicle
     * @return 
     */
    public void setMarcaModel(String marcaModel) {
        this.marcaModel = marcaModel;
    }

    /**
     * Getter de anyo de fabricacion de un vehicle
     * @return 
     */
    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    /**
     * Setter de anyo de fabricacion de un vehicle
     * @return 
     */
    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }

    /**
     * Getter de  propietario de un vehicle
     * @return 
     */
    public Client getPropietari() {
        return propietari;
    }

    /**
     * Setter de  propietario de un vehicle
     * @return 
     */
    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }
    
    
    
    
    
    


    /**
     * override de hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicle != null ? idVehicle.hashCode() : 0);
        return hash;
    }

    /**
     * Methodo equals
     * @param object
     * @return 
     */
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

    /**
     * To string para mostrar datos
     * @return 
     */
    @Override
    public String toString() {
        return "Vehicle{" + "idVehivle=" + idVehicle + ", matricula=" + matricula + ", marcaModel=" + marcaModel + ", anyFabricacio=" + anyFabricacio + ", propietari=" + propietari + '}';
    }

   
    
}
