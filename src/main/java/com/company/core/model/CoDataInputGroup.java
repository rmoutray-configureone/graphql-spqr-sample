package com.company.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the CO_Data_INPUT_GROUP database table.
 *
 */
@Entity
@Table(name = "CO_DATA_INPUT_GROUP")
@NamedQuery(name = "CoDataInputGroup.findAll", query = "SELECT c FROM CoDataInputGroup c")
public class CoDataInputGroup implements Serializable {

    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    private CoDataInputGroupPK id;

    @OneToMany(mappedBy = "coDataInputGroup", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<CoDataInput> coDataInputs;

    @MapsId(value = "dataId")
    @ManyToOne
    @JoinColumn(name = "DATA_ID", referencedColumnName = "DATA_ID")
    private CoData coData;

    public CoDataInputGroup() {
    }

    public CoDataInputGroupPK getId() {
        return this.id;
    }

    protected void setId(CoDataInputGroupPK id) {
        this.id = id;
    }

    public List<CoDataInput> getCoDataInputs() {
        return coDataInputs;
    }

    protected void setCoDataInputs(List<CoDataInput> coDataInputs) {
        this.coDataInputs = coDataInputs;
    }

    public CoData getCoData() {
        return coData;
    }

    protected void setCoData(CoData coData) {
        this.coData = coData;
    }

}
