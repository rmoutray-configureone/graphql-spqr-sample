package com.company.core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CO_Data_INPUT_GROUP database table.
 * 
 */
@Embeddable
public class CoDataInputGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final Long serialVersionUID = 1L;

	@Column(name="DATA_ID", unique=true, nullable=false)
	private Integer dataId;

	@Column(name="DATAIN_GROUP_NUM", unique=true, nullable=false)
	private Integer datainGroupNum;

	public CoDataInputGroupPK() {
	}

	public CoDataInputGroupPK(int dataId, int dataInputGroupNum) {
		this.dataId = dataId;
		this.datainGroupNum = dataInputGroupNum;
	}
	public Integer getDataId() {
		return this.dataId;
	}
	protected void setDATAId(Integer dataId) {
		this.dataId = dataId;
	}
	public Integer getDatainGroupNum() {
		return this.datainGroupNum;
	}
	protected void setDatainGroupNum(Integer DatainGroupNum) {
		this.datainGroupNum = DatainGroupNum;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CoDataInputGroupPK)) {
			return false;
		}
		CoDataInputGroupPK castOther = (CoDataInputGroupPK)other;
		return 
			(this.dataId == castOther.dataId)
			&& (this.datainGroupNum == castOther.datainGroupNum);
	}

	public int hashCode() {
		final Integer prime = 31;
		Integer hash = 17;
		hash = hash * prime + this.dataId;
		hash = hash * prime + this.datainGroupNum;
		
		return hash;
	}

	@Override
	public String toString() {
		return this.getDataId() + "-" + this.getDatainGroupNum();
	}
        
        
}