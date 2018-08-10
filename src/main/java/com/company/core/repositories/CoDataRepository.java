package com.company.core.repositories;

import com.company.core.model.CoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 02/07/2018
*/
@Repository
public interface CoDataRepository extends JpaRepository<CoData, Integer>, JpaSpecificationExecutor<CoData> {

    @RestResource(exported = false)
    @Override
    public CoData getOne(Integer id);
    
}
