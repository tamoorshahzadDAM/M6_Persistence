/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@NamedQueries({
//@NamedQuery(name="PersonaNom", query="SELECT p FROM Persona p WHERE p.nombre=:nombre")})
@NamedQuery(name=Client.CONSULTA, query="SELECT c FROM Client c WHERE c.nombre=:nombre")})
@Table(name = "M6UF2_CLIENT")
public class Client implements Serializable {
    
    public static final String CONSULTA = "ClientNom";
    
    @Embedded
    private Adreca adreca;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente")
    private String idClient;
    
    @Column(name = "nif", length = 9, nullable = false, unique =true)
    private String nif;
    
    @Column(name = "nomClient")
    private String nom;

    public Client() {
    }
    
    

    public Client(Adreca adreca, String idclient, String nif, String nom, Long id) {
        this.adreca = adreca;
        this.idClient = idclient;
        this.nif = nif;
        this.nom = nom;
        this.id = id;
    }

    public Adreca getAdreca() {
        return adreca;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    public String getIdclient() {
        return idClient;
    }

    public void setIdclient(String idclient) {
        this.idClient = idclient;
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "adreca=" + adreca + ", idclient=" + idClient + ", nif=" + nif + ", nom=" + nom + ", id=" + id + '}';
    }

    
    
}
