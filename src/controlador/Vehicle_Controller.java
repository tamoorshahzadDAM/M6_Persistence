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
import model.Vehicle;

/**
 *
 * @author ALUMNEDAM
 */
public class Vehicle_Controller {
    
    
    /**
     * Methodo que por parametros le pasamos un objeto vehicle y lo 
     * inserta en base de datos
     * @param p 
     */
    public void Insertar(Vehicle p) {
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
        etx.commit();

        System.out.println("close");
        em.close();
    }
    
    /**
     * Methodo que por parametros le pasamos un objeto Vehicle y lo modifica en 
     * base de datos, con ayuda de otro methodo de buscar, primero busca y 
     * luego modifica.
     * @param v 
     */
    public void Modificar(Vehicle v) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(v);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    /**
     * Methodo que por parametros le pasamos un objeto vehicle y lo 
     * elimina en base de datos.
     * @param p 
     */
    public void Eliminar(Vehicle v) {
        // Recupera el entity manager
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        // El persistim a la base de dades
        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(v) ? v : em.merge(v));

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
        Query q = em.createQuery("FROM VEHICLES");
        List<Vehicle> lista = (List<Vehicle>) q.getResultList();
        imprimirLista(lista);

        System.out.println("close");
        em.close();
    }

    /**
     * Methodo para imprimir una lista
     * @param lista 
     */
    public void imprimirLista(List<Vehicle> lista) {
        System.out.println("Numero de vehicles= " + lista.size());
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    
    /**
     * MEthodo que le paso una matricula por parametros y lo busca en base de datos
     * y lo devuelve ese vehicle con esa matricula.
     * @param mat
     * @return 
     */
    public Vehicle cercaVehicleMat(String mat) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per matricula");
        Query query = em.createNamedQuery("cercaVehicleMat", Vehicle.class);
        query.setParameter("matricula", mat);
        Vehicle v = (Vehicle) query.getSingleResult();
        System.out.println("close");
        em.close();
        return v;
    }
    
    /**
     * Methodo que le paso por parametros un id de un vehicle, y lo busca en base de datos
     * y devuelve ese vehicle.
     * @param id
     * @return 
     */
    public Vehicle cercaVehicle(Long id) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda per idVehicle");

        Vehicle c = (Vehicle) em.find(Vehicle.class, id);

        System.out.println("close");
        em.close();

        return c;
    }

    /**
     * Methodo que le paso por parametros un id de cliente, y lo busca en base de datos
     * y devuelve ese cliente.
     * @param id
     * @return 
     */
    public Client cercaClient(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de client per idClient ");
        Client c = (Client) em.find(Client.class, id);
        System.out.println(c);
        System.out.println("close");
        em.close();
        return c;
    }
}
