/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Adreca;
import model.Client;

/**
 *
 * @author ALUMNEDAM
 */
public class Adreca_Controller {
    
    
    /**
     * Methodo que por parametros le pasamos un objeto adreca y lo inserta en 
     * base de datos
     * @param a 
     */
    public void Insertar(Adreca a) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(a);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }
    
    /**
     * Methodo que por parametros le pasamos un objeto adreca y lo modifica en 
     * base de datos, con ayuda de otro methodo de buscar, primero busca y 
     * luego modifica
     * @param c 
     */
    public void Modificar(Adreca c) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(c);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Methodo que por parametros le pasamos un objeto asseguradora y lo elimina en 
     * base de datos.
     * @param a 
     */
    public void Eliminar(Adreca a) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(a) ? a : em.merge(a));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }
    
    /**
     * Methodo que hace consulta en base de datos.
     */
    public void Consulta() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM M6UF2_Adreca");
        List<Client> lista = (List<Client>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    /**
     * MEthodo para imprimir una lista
     * @param lista 
     */
    public void imprimirLista(List<Client> lista) {
        System.out.println("Numero de adrecas= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    
}
