/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.core.model.converters;

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
public class CoDataInputValuePKConverter implements BackendIdConverter {
    @Override
    public boolean supports(Class<?> type) {
        return CoDataInputValuePK.class.equals(type) || CoDataInputValue.class.equals(type);
    }

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        String[] idParts = id.split("-");
        int dataId = Integer.parseInt(idParts[0]);
        int dataInputNum = Integer.parseInt(idParts[1]);
        int DatainValueNum = Integer.parseInt(idParts[2]);
        return new CoDataInputValuePK(dataId, dataInputNum, DatainValueNum);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        CoDataInputValuePK idEntity = (CoDataInputValuePK) id;
        return idEntity.toString();
    }
}
