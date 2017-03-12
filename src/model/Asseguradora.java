/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
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
    //Query para mostrar asseguradora
    @NamedQuery(name = Asseguradora.CONSULTA, query = "SELECT a FROM Asseguradora a WHERE a.nomasseg=:nombre")})
//Nombre de tabla
@Table(name = "M6UF2_Asseguradora")
public class Asseguradora implements Serializable {

    public static final String CONSULTA = "nomAsseg";

    private static final long serialVersionUID = 1L;
    //Id de asseguradora
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAsseguradora", nullable = false)
    private Long idAsseg;

    //Columna para el nombre de asseguradora
    @Column(name = "nomAsseguradora", length = 100, nullable = false, unique = true)
    private String nomasseg;

    //Columna para nif de asseguradora
    @Column(name = "nifAsseguradora")
    private String nifAsseg;

    //Relacion uno a muchas, uniondo relacion con polissa
    @OneToMany(mappedBy = "numPolissa")
    List<Polissa> polissa = new ArrayList<>();

    /**
     * Constructor
     * @param nomasseg
     * @param nifAsseg 
     */
    public Asseguradora(String nomasseg, String nifAsseg) {
        this.nomasseg = nomasseg;
        this.nifAsseg = nifAsseg;
    }

    /**
     * constructor
     */
    public Asseguradora() {
    }

    /**
     * Getter de if asseguradora
     * @return 
     */
    public Long getIdAsseg() {
        return idAsseg;
    }

    /**
     * Setter de id asseguradora
     * @param idAsseg 
     */
    public void setIdAsseg(Long idAsseg) {
        this.idAsseg = idAsseg;
    }

    /**
     * Getter de nom asseguradora
     * @return 
     */
    public String getNomasseg() {
        return nomasseg;
    }

    /**
     * Stter de nom asseguradora
     * @param nomasseg 
     */
    public void setNomasseg(String nomasseg) {
        this.nomasseg = nomasseg;
    }

    /**
     * Getter de nif
     * @return 
     */
    public String getNifAsseg() {
        return nifAsseg;
    }

    /**
     * Setter de nif.
     * @param nifAsseg 
     */
    public void setNifAsseg(String nifAsseg) {
        this.nifAsseg = nifAsseg;
    }

    /**
     * override de hashcode
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsseg != null ? idAsseg.hashCode() : 0);
        return hash;
    }

    /**
     * Methodo equals
     *
     * @param object
     * @return
     */
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

    /**
     * To string para mostrar datos
     * @return 
     */
    @Override
    public String toString() {
        return "Asseguradora{" + "idAsseg=" + idAsseg + ", nomasseg=" + nomasseg + ", nifAsseg=" + nifAsseg + '}';
    }

}
