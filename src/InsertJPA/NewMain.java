/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertJPA;

import controlador.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Adreca;
import model.Asseguradora;
import model.Client;
import model.Polissa;
import model.Usuari;
import model.Vehicle;

/**
 *
 * @author HacKesGuRu
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
    
    /**
         DROP TABLE M6UF2_Adreca; 
         DROP TABLE M6UF2_POLISSA; 
         DROP TABLE M6UF2_USUARI; 
         DROP TABLE VEHICLES;
         DROP TABLE M6UF2_CLIENT; 
         DROP TABLE M6UF2_Asseguradora; 
         */
    
    
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Usuari user = new Usuari("tamoor", "123456");
        Adreca adre = new Adreca("Calle Monturiol", 60, "Ripollet");
        Client client = new Client(adre, "X8587455Z", "Tamoor Shahzad");
        Client pre = new Client(adre, "X8587455Z", "Tamoor Shahzad");

        Vehicle vehicle = new Vehicle("0295CDY", "Renault", 2003, client, null);
        Asseguradora asse = new Asseguradora("Mutua", "x8587455z");
        Polissa pol = new Polissa("12345679", pre, vehicle, client, sdf.parse("11-03-2017"), sdf.parse("11-03-2018"), true, asse, 400);

        
        
       // *******************************  Client *********************************
        

        // --------- Insertar Cliente ------------
        
        Client_Controller cc = new Client_Controller();
        //cc.Insertar(client);
 

/**
        // ---------------- Elimina -------------------
        //elimina
        cc.Eliminar(client);
*/

/**
        // ---------------- Buscar por nombre ---------------------------
        Imprime un cliente, busca por nombre
        cc.imprimir(cc.BuscarPerNom("Tamoor Shahzad"));
*/   


/**
         // ------------------- Modificar --------------
        //Busco por numero en base de datos, y lo cambio el capo que quiero
        //modificar 
        Client c = cc.BuscarPerNom("Tamoor Shahzad");
        c.setNom("Tamoor"); 
        cc.Modificar(c);
*/



// *************************  Usuario ******************************************


/**
        // ------------USUARI ----------------
        Usuari_Controller uc = new Usuari_Controller();
        uc.Insertar(user);
*/

/**
        //Modifica
        Usuari u = uc.BuscarPerNom("tamoor");
        u.setUsuario("Tamoor Shahzad");
        u.setContra("1234");
        uc.Modificar(u);
        System.out.println(u);
*/

/**
        // ----------- Borrar --------------
        Usuari u = uc.BuscarPerNom("prueba11");
        uc.Eliminar(u);
*/

        Polissa_Controller pc = new Polissa_Controller();
        //pc.Insertar(pol);


        Vehicle_Controller vehi = new Vehicle_Controller();
        vehi.Insertar(vehicle);

    }

}
