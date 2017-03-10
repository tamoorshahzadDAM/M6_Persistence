/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertJPA;

import controlador.Client_Controller;
import model.Client;

/**
 *
 * @author ALUMNEDAM
 */
public class PolissaJPA {
    
    public static void main(String[] args) {
        try {

            ////  --------------Insertar-------------------
            //Insertar un cliente
            Client_Controller cc = new Client_Controller();
            Client cli1 = cc.BuscarPerNom("Tamoor Shahzad");
            
            
            
     /**       
            //Adreca adr = new Adreca();
            adr.setCarrer("C/Monturiol ");
            adr.setNumero(60);
            adr.setPoblacion("Ripollet");

            cli1.setNif("X8587455Z");
            cli1.setNom("Tamoor Shahzad");
            cli1.setAdreca(adr);

            //------------ INSERTAR -----------------------
            
            // cc.Insertar(cli1);
            ///  ------------------------------------------

            /// ----------- BUSCAR ------------------------
            String nom = "Tamoor Shahzad";
            Client c = cc.BuscarPerNom(nom); //PRIMER IDPERSONA
            cc.imprimir(c);

            //////// --------------- BORRAR ---------------
            //Borra por nombre
            //String nom = "Tamoor Shahzad";
            //Client c = cc.BuscarPerNom(nom);
            //cc.Eliminar(c); //Para borar el cliente
            //-------------- Nodificar---------------------
            Adreca adrmod = new Adreca();
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
