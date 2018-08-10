/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.core;

import java.sql.Types;

/**
 * Custom SQLServerDialect to allow both varchars and nvarchars to map to String in the model entities.
 * @author rmoutray
 */
public class C1SQLServerDialect extends org.hibernate.dialect.SQLServer2012Dialect {

    private static final int VARCHAR_MAX_LENGTH = 4000;
    
    /**
     * Constructor for the class.
     */
    public C1SQLServerDialect() {
        //Since String is already tied to type VARCHAR, we must make type VARCHAR also accept nvarchar columns.
        //Explicitely specifying the max length allows this mapping to take precedence over other mappings in 
        //inherited class dialects.
        registerColumnType(Types.VARCHAR, VARCHAR_MAX_LENGTH, "nvarchar($l)");
    }
    

    

}
