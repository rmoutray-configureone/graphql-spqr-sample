package com.company.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the CO_Data_INPUT_VALUE database table.
 *
 */
@Entity
@Table(name = "CO_Data_INPUT_VALUE")
@NamedQuery(name = "CoDataInputValue.findAll", query = "SELECT c FROM CoDataInputValue c")
public class CoDataInputValue implements Serializable {

    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    private CoDataInputValuePK id;

    @Column(name = "DATAIN_VAL", length = 50)
    private String datainVal;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumns(
            {
                @JoinColumn(name = "DATA_ID", referencedColumnName = "DATA_ID")
                ,
                @JoinColumn(name = "DATA_INPUT_NUM", referencedColumnName = "DATA_INPUT_NUM")
                ,
                @JoinColumn(name = "DATA_INPUT_VAL_NUM", referencedColumnName = "DATAIN_VALUE_NUM"),}
    )
    private List<CoDataInputAttribute> coDataInputAttributes;

    public CoDataInputValue() {
    }

    public CoDataInputValuePK getId() {
        return this.id;
    }

    protected void setId(CoDataInputValuePK id) {
        this.id = id;
    }

    public String getDatainVal() {
        return this.datainVal;
    }

    protected void setDatainVal(String DatainVal) {
        this.datainVal = DatainVal;
    }

    public List<CoDataInputAttribute> getCoDataInputAttributes() {
        return coDataInputAttributes;
    }

    protected void setCoDataInputAttributes(List<CoDataInputAttribute> coDataInputAttributes) {
        this.coDataInputAttributes = coDataInputAttributes;
    }

}
