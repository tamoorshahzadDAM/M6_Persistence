/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertJPA;

import controlador.Asseguradora_Controller;
import controlador.Client_Controller;
import model.Adreca;
import model.Asseguradora;
import model.Client;

/**
 *
 * @author ALUMNEDAM
 */
public class AsseguradoraJPA {
    
    public static void main(String[] args) {
        try {

            ////  --------------Insertar-------------------
            // Insertar un cliente
            Asseguradora asse = new Asseguradora();
            
            asse.setIdAsseg(Long.MIN_VALUE);
            asse.setNifAsseg("123456");
            asse.setNomasseg("Mutua");
            


            //------------ INSERTAR -----------------------
            Asseguradora_Controller ac = new Asseguradora_Controller();
            ac.Insertar(asse);
            ///  ------------------------------------------

            /// ----------- BUSCAR ------------------------
            String nom = "Mutua";
            Asseguradora a = ac.BuscarPerNom(nom);//PRIMER IDPERSONA
            ac.imprimir(a);

            //////// --------------- BORRAR ---------------
            //Borra por nombre
            //String nom = "Tamoor Shahzad";
            //Client c = cc.BuscarPerNom(nom);
            //cc.Eliminar(c); //Para borar el cliente
            //-------------- Nodificar---------------------
            
   /**         
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
