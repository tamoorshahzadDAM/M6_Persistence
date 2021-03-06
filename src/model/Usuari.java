/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
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
    @NamedQuery(name = Usuari.CONSULTA, query = "SELECT u FROM Usuari u WHERE u.usuario=:nombre")
})
@Table(name = "M6UF2_USUARI")
public class Usuari implements Serializable {
    
    public static final String CONSULTA = "nomUsuario";

    //Columna para usuario
    @Column(name = "usuario", length = 30, nullable = false, unique = true)
    private String usuario;

    //Columna para password
    @Column(name = "contrasenya", nullable = false, length = 30)
    private String contra;

    /**
     * Constructor vacio.
     */
    public Usuari() {

    }

    /**
     * Constructor
     * @param usuario
     * @param contra 
     */
    public Usuari(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
    }

    /**
     * Getter de usuario
     * @return 
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Setter de usuario
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * GEtter de contrasenya
     * @return 
     */
    public String getContra() {
        return contra;
    }

    /**
     * Setter de contrasenya, que minimum sea 6 caracters.
     * @param contra 
     */
    public void setContra(String contra) {
        if (contra.length() >= 6) {
            this.contra = contra;
        }
    }

    private static final long serialVersionUID = 1L;
    //Id de usuari
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Getter de id usuari
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * override de hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        if (!(object instanceof Usuari)) {
            return false;
        }
        Usuari other = (Usuari) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
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
        return "Usuari{" + "usuario=" + usuario + ", contra=" + contra + ", id=" + id + '}';
    }

    
}
