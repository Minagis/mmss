package com.example.mms.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @SequenceGenerator(name = "abstract_generator", sequenceName = "abstract_sequence", allocationSize = 1)
    @GeneratedValue(generator = "abstract_generator")
    private Integer id;

    public Integer getId() {
        return id;
    }
}
