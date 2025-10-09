package service;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerAdmin {
    private static String UNIDAD_PERSISTENCE = "DEMOJPA";

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory(UNIDAD_PERSISTENCE);
        EntityManager em = emf.createEntityManager();
        return em;
    }
    private EntityManagerAdmin() {}
}
