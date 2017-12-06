package com.javamentor.dao;

import com.javamentor.model.AbstractModel;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class CrudDaoImpl<T extends AbstractModel, PK extends Serializable> implements CrudDao<T, PK> {

    @PersistenceUnit
    EntityManagerFactory emf;

    public abstract List<T> getAll();

    public abstract T findByKey(PK key);

    public void update(T entity) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

    }

    public void save(T entity) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

    }

    public void deleteByKey(PK key) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(findByKey(key));
        em.getTransaction().commit();

    }

}
