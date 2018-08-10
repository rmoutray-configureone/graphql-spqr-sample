package com.company.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the CO_Data_INPUT database table.
 *
 */
@Entity
@Table(name = "CO_DATA_INPUT")
@NamedQuery(name = "CoDataInput.findAll", query = "SELECT c FROM CoDataInput c")
public class CoDataInput implements Serializable {

    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    private CoDataInputPK id;

    @Column(name = "DATAIN_GROUP_NUM")
    private Integer datainGroupNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(
    {
        @JoinColumn(name = "DATA_ID", referencedColumnName = "DATA_ID", insertable = false, updatable = false)
        ,
        @JoinColumn(name = "DATAIN_GROUP_NUM", referencedColumnName = "DATAIN_GROUP_NUM", insertable = false, updatable = false),}
    )
    private CoDataInputGroup coDataInputGroup;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumns(
            {
                @JoinColumn(name = "DATA_ID", referencedColumnName = "DATA_ID")
                ,
                @JoinColumn(name = "DATA_INPUT_NUM", referencedColumnName = "DATA_INPUT_NUM"),}
    )
    private List<CoDataInputValue> coDataInputValues;

    public CoDataInput() {
    }

    public CoDataInputPK getId() {
        return this.id;
    }

    protected void setId(CoDataInputPK id) {
        this.id = id;
    }

    public Integer getDatainGroupNum() {
        return this.datainGroupNum;
    }

    protected void setDatainGroupNum(Integer datainGroupNum) {
        this.datainGroupNum = datainGroupNum;
    }

    public List<CoDataInputValue> getCoDataInputValues() {
        return coDataInputValues;
    }

    protected void setCoDataInputValues(List<CoDataInputValue> coDataInputValues) {
        this.coDataInputValues = coDataInputValues;
    }

    public CoDataInputGroup getCoDataInputGroup() {
        return coDataInputGroup;
    }

    protected void setCoDataInputGroup(CoDataInputGroup coDataInputGroup) {
        this.coDataInputGroup = coDataInputGroup;
    }

}
