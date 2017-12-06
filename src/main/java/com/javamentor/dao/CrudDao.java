package com.javamentor.dao;

import com.javamentor.model.AbstractModel;

import java.io.Serializable;
import java.util.List;

public interface CrudDao<T extends AbstractModel, PK extends Serializable> {

    List<T> getAll();

    T findByKey(PK key);

    void update(T entity);

    void save(T entity);

    void deleteByKey(PK key);

}
