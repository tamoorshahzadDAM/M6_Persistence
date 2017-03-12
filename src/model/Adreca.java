/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 *
 * @author ALUMNEDAM
 */
@Embeddable
@Table(name = "M6UF2_Adreca")
public class Adreca implements Serializable {

    //Columna de calle
    @Column(name = "carrer", length = 50, nullable = false)
    private String carrer;
    
    //Columna de numero de piso
    @Column(name = "numero", length = 20, nullable = false)
    private int numero;
    
    //Columna de nombre de poblacaion
    @Column(name = "poblacion", length = 50, nullable = false)
    private String poblacion;

    /**
     * Constructor de adreca
     * @param carrer
     * @param numero
     * @param poblacion 
     */
    public Adreca(String carrer, int numero, String poblacion) {
        this.carrer = carrer;
        this.numero = numero;
        this.poblacion = poblacion;
    }

    /**
     * Constructor
     */
    public Adreca() {
    }
    
    

    /**
     * Getter de carrer
     * @return 
     */
    public String getCarrer() {
        return carrer;
    }

    /**
     * Setter de carrer
     * @param carrer 
     */
    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    /**
     * Getter de numero de piso
     * @return 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setter de numero de piso
     * @param numero 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Getter de poblacion
     * @return 
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Setter de poblacion
     * @param poblacion 
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * To string para mostrar datos
     * @return 
     */
    @Override
    public String toString() {
        return "Adreca{" + "carrer=" + carrer + ", numero=" + numero + ", poblacion=" + poblacion + '}';
    }

    
    
    
    
}
