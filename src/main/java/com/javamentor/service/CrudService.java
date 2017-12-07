package com.javamentor.service;

import com.javamentor.model.AbstractModel;

import java.util.List;

public interface CrudService<T extends AbstractModel, PK> {

    List<T> getAll();

    T findByKey(PK key);

    void persist(T entity);

    void deleteByKey(PK key);

}
