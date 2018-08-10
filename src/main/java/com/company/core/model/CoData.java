package com.company.core.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


/**
 * The persistent class for the CO_Data database table.
 * 
 */
@Entity
@Table(name="CO_DATA")
@NamedQuery(name="CoData.findAll", query="SELECT c FROM CoData c")
public class CoData implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@Column(name="DATA_ID", unique=true, nullable=false)
	private Integer dataId;

	@Column(name="DATA_DESC", length=100)
	private String dataDesc;
        
        @OneToMany(mappedBy = "coData", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
        private List<CoDataInputGroup> coDataInputGroups;

	public CoData() {
	}

	public Integer getDataId() {
		return this.dataId;
	}

	protected void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public String getDataDesc() {
		return this.dataDesc;
	}

	protected void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}

	public List<CoDataInputGroup> getCoDataInputGroup() {
		return coDataInputGroups;
	}

	protected void setCoDataInputGroup(List<CoDataInputGroup> coDataInputGroup) {
		this.coDataInputGroups = coDataInputGroup;
	}

}