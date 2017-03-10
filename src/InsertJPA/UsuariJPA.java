/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertJPA;

import controlador.Usuari_Controller;
import model.Usuari;



/**
 *
 * @author ALUMNEDAM
 */
public class UsuariJPA {
    
    public static void main(String[] args) {
        try {

            ////  --------------Insertar-------------------
            // Insertar un cliente
            
            Usuari user = new Usuari();
            user.setUsuario("tamoor");
            user.setUsuario("1234");
            
            

            //------------ INSERTAR -----------------------
            Usuari_Controller uc = new Usuari_Controller();
            uc.Insertar(user);
            ///  ------------------------------------------

            
            //////// --------------- BORRAR ---------------
            //Borra por nombre
            String nom = "tamoor";
            uc.Eliminar(user); //Para borar el cliente
            
  /**          
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
