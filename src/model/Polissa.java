/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author ALUMNEDAM
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cerca_Polissa_Prenedor", query = "SELECT p FROM Polissa p WHERE p.prenedor=:Prenedor"),
    @NamedQuery(name = "buscaPerNom", query = "SELECT p FROM Polissa p WHERE p.numPolissa:nombre"),
    //@NamedQuery(name = Polissa.Polissa_Vehicle, query = "SELECT p FROM Polissa p WHERE p.vehicle:Vehicle")
    //@NamedQuery(name = "Cerca_Polissa_Client", query = "SELECT p FROM Polissa p WHERE p.cliente.idClient:cliente"),
    @NamedQuery(name = "Cerca_Polissa_Vehicle", query = "SELECT p FROM Polissa p WHERE p.vehicle.idVehicle=:vehicle")
})
@Table(name = "M6UF2_POLISSA")
public class Polissa implements Serializable {

    
    //public static final String Polissa_Prenedor = "PolissaPrenedor";
    //public static final String Polissa_Vehicle = "PolissaVehicle";
    //public static final String Cerca_Polissa_Client = "CercaPolissaClient";
    
    
    
    
    private static final long serialVersionUID = 1L;
    //Id de polissa
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPolissa", unique = true)
    private int idPolissa;

    //Columna para numero de polissa
    @Column(name = "numPolissa", length = 10)
    private String numPolissa;

    // Columna para prenedor
    @Column(name = "prenedor", nullable = false)
    @IndexColumn(name = "indexPrenedor")
    @Basic(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne
    //@JoinColumn(name="propietariPolissa")
    private Client prenedor;

    //Columna para vehicle, tienes relacion uno a uno
    //@Column(name = "vehicle", nullable = false)
    //@Basic(fetch = FetchType.LAZY)
    @OneToOne(cascade=CascadeType.ALL) 
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;
    
    //Relacion muchos a uno, con idclient
    @ManyToOne(cascade=CascadeType.ALL) 
    @Basic(fetch = FetchType.LAZY)
    @JoinColumn(name = "idClient")
    private Client cliente;

    //Columna para fecha de inicio
    @Column(name = "dataInici", nullable = false)
    private Date dataInici;

    //Columna para fecha final
    @Column(name = "dataFi", nullable = false)
    private Date dataFi;

    //Columna para tipos de polissa, es un boolean
    @Column(name = "tipuPolissa", nullable = false)
    //@ElementCollection
    //@Enumerated(EnumType.STRING)
    private boolean tipuPolissa;

    //Relacion de muchos a uno con id de asseguradora
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "asseguradoraId")
    private Asseguradora asseguradora;
    
    //Columna para prima el costo.
    @Column (name = "prima")
    private double prima;

    /**
     * Constructor de polissa
     * @param numPolissa
     * @param prenedor
     * @param vehicle
     * @param cliente
     * @param dataInici
     * @param dataFi
     * @param tipuPolissa
     * @param asseguradora
     * @param prima 
     */
    public Polissa(String numPolissa, Client prenedor, Vehicle vehicle, Client cliente, Date dataInici, Date dataFi, boolean tipuPolissa, Asseguradora asseguradora, double prima) {
        this.numPolissa = numPolissa;
        this.prenedor = prenedor;
        this.vehicle = vehicle;
        this.cliente = cliente;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipuPolissa = tipuPolissa;
        this.asseguradora = asseguradora;
        this.prima = prima;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public Asseguradora getAsseguradora() {
        return asseguradora;
    }

    public void setAsseguradora(Asseguradora asseguradora) {
        this.asseguradora = asseguradora;
    }

    

    /**
     * Constructor vacio
     */
    public Polissa() {
    }

    /**
     * Getter de id de polissa
     * @return 
     */
    public int getIdPolissa() {
        return idPolissa;
    }

    /**
     * Setter de id de polissa
     * @return 
     */
    public void setIdPolissa(int idPolissa) {
        this.idPolissa = idPolissa;
    }

    /**
     * Getter de numero de polissa
     * @return 
     */
    public String getNumPolissa() {
        return numPolissa;
    }

    /**
     * Setter de numero de polissa
     * @return 
     */
    public void setNumPolissa(String numPolissa) {
        this.numPolissa = numPolissa;
    }

    /**
     * Getter de prenedor de polissa
     * @return 
     */
    public Client getPrenedor() {
        return prenedor;
    }

    /**
     * Setter de prenedor de polissa
     * @return 
     */
    public void setPrenedor(Client prenedor) {
        this.prenedor = prenedor;
    }

    /**
     * Getter de vehicle 
     * @return 
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Setter de vehicle 
     * @return 
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Getter de fecha de inicio 
     * @return 
     */
    public Date getDataInici() {
        return dataInici;
    }

    /**
     * Setter de fecha de inicio 
     * @return 
     */
    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    /**
     * Getter de fecha de fin 
     * @return 
     */
    public Date getDataFi() {
        return dataFi;
    }

    /**
     * Setter de fecha de fin 
     * @return 
     */
    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    /**
     * Getter de tipus de polissa
     * @return 
     */
    public boolean getTipuPolissa() {
        return tipuPolissa;
    }

    /**
     * Setter de tipus de polissa
     * @return 
     */
    public void setTipuPolissa(boolean tipuPolissa) {
        this.tipuPolissa = tipuPolissa;
        
    }

    /**
     * Getter de Prima
     * @return 
     */
    public double getPrima() {
        return prima;
    }

    /**
     * Setter de Prima
     * @return 
     */
    public void setPrima(double prima) {
        this.prima = prima;
    }
    
    
    
    
    
    /**
     * override de hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPolissa != null ? numPolissa.hashCode() : 0);
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
        if (!(object instanceof Polissa)) {
            return false;
        }
        Polissa other = (Polissa) object;
        if ((this.numPolissa == null && other.numPolissa != null) || (this.numPolissa != null && !this.numPolissa.equals(other.numPolissa))) {
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
        return "Polissa{" + "idPolissa=" + idPolissa + ", numPolissa=" + numPolissa + ", prenedor=" + prenedor + ", vehicle=" + vehicle + ", cliente=" + cliente + ", dataInici=" + dataInici + ", dataFi=" + dataFi + ", tipuPolissa=" + tipuPolissa + ", asseguradora=" + asseguradora + ", prima=" + prima + '}';
    }

    

    

}
