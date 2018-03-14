package com.example.mms.dao;

import com.example.mms.entity.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractDao<T extends AbstractEntity, E extends Serializable> extends CrudRepository<T, E> {
}
