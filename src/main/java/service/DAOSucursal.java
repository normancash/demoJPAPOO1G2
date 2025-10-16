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

    }

    @Override
    public void update(Sucursal sucursal) {

    }

    @Override
    public void delete(Sucursal sucursal) {

    }

    @Override
    public Sucursal findById(Integer id) {
        return null;
    }
}
