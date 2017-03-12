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
import model.Usuari;

/**
 *
 * @author ALUMNEDAM
 */
public class Usuari_Controller {
    
    /**
     * Methodo que por parametros le pasamos un objeto Usuari y lo 
     * inserta en base de datos
     * @param u 
     */
    public void Insertar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(u);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }
    
    /**
     * Methodo que por parametros le pasamos un objeto Usuari y lo modifica en 
     * base de datos, con ayuda de otro methodo de buscar, primero busca y 
     * luego modifica.
     * @param u 
     */
    public void Modificar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(u);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Methodo que por parametros le pasamos un objeto Usuari y lo 
     * elimina en base de datos
     * @param u 
     */
    public void Eliminar(Usuari u) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(u) ? u : em.merge(u));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }
    
    /**
     * MEthodo que hace consulta en base de datos
     */
    public void Consulta() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
        //List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM M6UF2_USUARI");
        List<Usuari> lista = (List<Usuari>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    /**
     * Methodo para imprimir una lista
     * @param lista 
     */
    public void imprimirLista(List<Usuari> lista) {
        System.out.println("Numero de Usuaris= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    
    /**
     * Methodo que le paso por parametros un nombre, y lo busca en base de datos
     * y devuelve.
     * @param nom
     * @return 
     */
    public Usuari BuscarPerNom(String nom) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery(Usuari.CONSULTA,Usuari.class);
        query.setParameter("nombre", nom);
        Usuari c = (Usuari) query.getSingleResult();

        System.out.println("close");
        em.close();

        return c;
    }
    
    
}
