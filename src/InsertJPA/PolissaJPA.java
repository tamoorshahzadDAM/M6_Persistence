/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertJPA;

import controlador.Client_Controller;
import java.text.SimpleDateFormat;
import model.Adreca;
import model.Asseguradora;
import model.Client;
import model.Polissa;
import model.Vehicle;

/**
 *
 * @author ALUMNEDAM
 */
public class PolissaJPA {
    
    public static void main(String[] args) {
        try {

            ////  --------------Insertar-------------------
            // Insertar un cliente
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Polissa pol = new Polissa();
           
            pol.setIdPolissa(0);
            pol.setNumPolissa("123456");
            
            Adreca adre = new Adreca("Calle Padro", 1, "Ripollet");
            Client client = new Client(adre, "X8587455Z", "Tamoor");
            
            Vehicle vehicle = new Vehicle("0295CDY", "Renault", 2003, client, null);
            Asseguradora asse = new Asseguradora("Mutua", "x8587455z");
            //Polissa poli = new Polissa("1234", client, vehicle, sdf.parse("11-03-2017"), sdf.parse("11-03-2018"), true, asse);
            
            pol.setDataInici(sdf.parse("11/03/2017"));

            
/**
            //------------ INSERTAR -----------------------
            Client_Controller cc = new Client_Controller();
            //cc.Insertar(cli1);
            ///  ------------------------------------------
*/

/**
            /// ----------- BUSCAR ------------------------
            String nom = "Tamoor Shahzad";
            Client c = cc.BuscarPerNom(nom); //PRIMER IDPERSONA
            cc.imprimir(c);
*/


/**
            //////// --------------- BORRAR ---------------
            //Borra por nombre
            String nom = "prueba Shahzad";
            Client c = cc.BuscarPerNom(nom);
            cc.Eliminar(c); //Para borar el cliente
 */           
         
/**
            //-------------- Nodificar---------------------
            Client_Controller cc = new Client_Controller();
            Adreca adrmod = new Adreca();
            String nom = "Tamoor Shahzad";
            Client c = cc.BuscarPerNom(nom);
            
            adrmod.setCarrer("C/Mont ");
            adrmod.setNumero(60);
            adrmod.setPoblacion("Ripo");

            c.setNom("Tamoor");
            c.setAdreca(adrmod);
            cc.Modificar(c);
*/


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
