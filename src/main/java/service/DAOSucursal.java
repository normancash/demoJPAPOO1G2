package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Sucursal;
import org.hibernate.QueryException;

import java.sql.SQLException;
import java.util.List;

public class DAOSucursal implements IDAOSucursal{
    @Override
    public List<Sucursal> getAll() {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
           TypedQuery<Sucursal> query = em.createNamedQuery("Sucursal.findAll", Sucursal.class);
           return query.getResultList();
        }
        catch(QueryException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return null;
    }

    @Override
    public void insert(Sucursal sucursal) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(sucursal);
            em.flush();
            em.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }

    }

    @Override
    public void update(Sucursal sucursal) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(sucursal);
            em.flush();
            em.getTransaction().commit();
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {em.close();}
    }

    @Override
    public void delete(Sucursal sucursal) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(sucursal));
            em.flush();
            em.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {em.close();}
    }

    @Override
    public Sucursal findById(Integer id) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            Sucursal sucursal = em.find(Sucursal.class, id);
            return sucursal;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {em.close();}
        return null;
    }
}
