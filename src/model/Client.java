/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@NamedQueries({
    //@NamedQuery(name="PersonaNom", query="SELECT p FROM Persona p WHERE p.nombre=:nombre")})
    //Query para buscar un client segun el nombre
    @NamedQuery(name = Client.CONSULTA, query = "SELECT c FROM Client c WHERE c.nom=:nombre")})
@Table(name = "M6UF2_CLIENT")
public class Client implements Serializable {

    public static final String CONSULTA = "nomClient";

    @Embedded
    private Adreca adreca;

    //Id de cliente, es va generando automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente")
    private Long idClient;

    //Columna de nif
    @Column(name = "nif", length = 9, nullable = false, unique = true)
    private String nif;
    
    

    //Columna de nombre de cliente
    @Column(name = "nomClient")
    private String nom;
    
    //Relacion un a muchos
    @OneToMany (mappedBy = "propietari")
    List<Vehicle> vehicle = new ArrayList<>();
    
    // Relation uno a muchos, una polissa solamente se puede sociar a un client, en cambio al reves
    //Pueden ser mas de un.
    @OneToMany (mappedBy = "prenedor")
    List<Polissa> polissa = new ArrayList<>();
    

    public Client() {
    }

    /**
     * Constructor
     * @param adreca
     * @param nif
     * @param nom 
     */
    public Client(Adreca adreca, String nif, String nom) {
        this.adreca = adreca;
        this.nif = nif;
        this.nom = nom;
    }

    /**
     * Getter de adreca
     * @return 
     */
    public Adreca getAdreca() {
        return adreca;
    }

    /**
     * Setter de adreca
     * @return 
     */
    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    /**
     * Getter de idClient
     * @return 
     */
    public Long getIdClient() {
        return idClient;
    }

    /**
     * Setter de idClient
     * @return 
     */
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    /**
     * Getter de nif
     * @return 
     */
    public String getNif() {
        return nif;
    }

    /**
     * Setter de nif
     * @return 
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Getter de nombre de cliente
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter de nombre de cliente
     * @return 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    private static final long serialVersionUID = 1L;

    /**
     * override de hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
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
        return "Client{" + "adreca=" + adreca + ", idClient=" + idClient + ", nif=" + nif + ", nom=" + nom + ", id=" + idClient + '}';
    }

}
