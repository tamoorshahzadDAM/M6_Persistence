/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ALUMNEDAM
 */
@Embeddable
public class Adreca implements Serializable {

    @Column(name = "carrer", length = 50, nullable = false)
    private String carrer;
    
    @Column(name = "numero", length = 20, nullable = false)
    private int numero;
    
    @Column(name = "poblacion", length = 50, nullable = false)
    private String poblacion;

    public Adreca(String carrer, int numero, String poblacion) {
        this.carrer = carrer;
        this.numero = numero;
        this.poblacion = poblacion;
    }
    
    

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Adreca{" + "carrer=" + carrer + ", numero=" + numero + ", poblacion=" + poblacion + '}';
    }

    
    
    
    
}
