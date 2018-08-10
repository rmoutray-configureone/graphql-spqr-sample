/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.core.model.converters;

import com.company.core.model.CoDataInput;
import com.company.core.model.CoDataInputGroup;
import com.company.core.model.CoDataInputGroupPK;
import com.company.core.model.CoDataInputPK;
import com.company.core.model.CoDataInputValue;
import com.company.core.model.CoDataInputValuePK;
import java.io.Serializable;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author rmoutray
 */
@Component
public class CoDataInputGroupPKConverter implements BackendIdConverter {
    @Override
    public boolean supports(Class<?> type) {
        return CoDataInputGroupPK.class.equals(type) || CoDataInputGroup.class.equals(type);
    }

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        String[] idParts = id.split("-");
        int dataId = Integer.parseInt(idParts[0]);
        int dataInputGroupNum = Integer.parseInt(idParts[1]);
        return new CoDataInputGroupPK(dataId, dataInputGroupNum);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        CoDataInputGroupPK ptid = (CoDataInputGroupPK) id;
        return ptid.toString();
    }
}
