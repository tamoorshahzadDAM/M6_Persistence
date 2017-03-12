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
import model.Client;
import model.Polissa;

/**
 *
 * @author ALUMNEDAM
 */
public class Polissa_Controller {
    
    
    
    /**
     * Methodo que por parametros le pasamos un objeto Polissa y lo 
     * inserta en base de datos
     * @param p 
     */
    public void Insertar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }
    
    /**
     * Methodo que por parametros le pasamos un objeto Polissa y lo modifica en 
     * base de datos, con ayuda de otro methodo de buscar, primero busca y 
     * luego modifica.
     * @param p 
     */
    public void Modificar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Methodo que por parametros le pasamos un objeto Polissa y lo 
     * elimina en base de datos
     * @param p 
     */
    public void Eliminar(Polissa p) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

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
        Query q = em.createQuery("FROM M6UF2_POLISSA");
        List<Polissa> lista = (List<Polissa>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    /**
     * Methodo para imprimir una lista
     * @param lista 
     */
    public void imprimirLista(List<Polissa> lista) {
        System.out.println("Numero de Polissas= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    
    /**
     * Methodo que por parametro le paso un cliente y el lo busca en la lista y
     * lo muestra.
     * @param client 
     */
    public void BuscarPerClientLlista(Client client) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per idClient");
        Query query = em.createNamedQuery("cerca_Polizas_Cliente", Polissa.class);
        query.setParameter("cliente", client.getIdClient());
        List<Polissa> lista = (List<Polissa>) query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
    }
    
    /**
     * Methodo que le paso por parametros un nombre, y lo busca en base de datos
     * y devuelve.
     * @param nom
     * @return 
     */
    public Client BuscarPerNom(String nom) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery(Client.CONSULTA,Client.class);
        query.setParameter("nombre", nom);
        Client c = (Client) query.getSingleResult();

        System.out.println("close");
        em.close();

        return c;
    }
    
}
