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
    @NamedQuery(name = Client.CONSULTA, query = "SELECT c FROM Client c WHERE c.nom=:nombre")})
@Table(name = "M6UF2_CLIENT")
public class Client implements Serializable {

    public static final String CONSULTA = "nomClient";

    @Embedded
    private Adreca adreca;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente")
    private Long idClient;

    @Column(name = "nif", length = 9, nullable = false, unique = true)
    private String nif;
    
    

    @Column(name = "nomClient")
    private String nom;
    
    @OneToMany (mappedBy = "propietari")
    List<Vehicle> vehicle = new ArrayList<>();
    
    @OneToMany (mappedBy = "prenedor")
    List<Polissa> polissa = new ArrayList<>();
    

    public Client() {
    }

    public Client(Adreca adreca, Long idClient, String nif, String nom) {
        this.adreca = adreca;
        this.idClient = idClient;
        this.nif = nif;
        this.nom = nom;
    }

    public Adreca getAdreca() {
        return adreca;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Client{" + "adreca=" + adreca + ", idClient=" + idClient + ", nif=" + nif + ", nom=" + nom + ", id=" + idClient + '}';
    }

}
