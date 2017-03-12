/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertJPA;

import controlador.Client_Controller;
import model.Adreca;
import model.Client;

/**
 *
 * @author ALUMNEDAM
 */
public class ClientJPA {

    public static void main(String[] args) {
        try {

            ////  --------------Insertar-------------------
            // Insertar un cliente
            Client cli1 = new Client();
            Adreca adr = new Adreca();
            adr.setCarrer("C/Monturiol ");
            adr.setNumero(60);
            adr.setPoblacion("Ripollet");

            cli1.setNif("X8587455Z");
            cli1.setNom("Tamoor Shahzad");
            cli1.setAdreca(adr);

            //------------ INSERTAR -----------------------
            Client_Controller cc = new Client_Controller();
            cc.Insertar(cli1);
            ///  ------------------------------------------


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
