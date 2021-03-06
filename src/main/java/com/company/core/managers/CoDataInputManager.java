package com.company.core.managers;

import org.springframework.stereotype.Component;

import com.company.core.managers.base.CoGenericAbstractManager;
import com.company.core.model.CoDataInput;
import com.company.core.model.CoDataInputPK;
import com.company.core.repositories.CoDataInputRepository;


/**
* Generated by Spring Data Generator on 02/07/2018
*/
@Component
public class CoDataInputManager extends CoGenericAbstractManager<CoDataInput, CoDataInputPK, CoDataInputRepository> {

    public CoDataInputManager(CoDataInputRepository repo) {
        super(repo);
        // TODO Auto-generated constructor stub
    }
}
