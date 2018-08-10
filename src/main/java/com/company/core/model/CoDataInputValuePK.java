package com.company.core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CO_Data_INPUT_VALUE database table.
 * 
 */
@Embeddable
public class CoDataInputValuePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final Long serialVersionUID = 1L;

	@Column(name="DATA_ID", unique=true, nullable=false)
	private Integer dataId;

	@Column(name="DATA_INPUT_NUM", unique=true, nullable=false)
	private Integer dataInputNum;

	@Column(name="DATAIN_VALUE_NUM", unique=true, nullable=false)
	private Integer datainValueNum;

	public CoDataInputValuePK() {
	}

	public CoDataInputValuePK(int dataId, int dataInputNum, int DatainValueNum) {
		this.dataId = dataId;
		this.dataInputNum = dataInputNum;
		this.datainValueNum = DatainValueNum;
	}
        
	public Integer getDataId() {
		return this.dataId;
	}
	protected void setDATAId(Integer dataId) {
		this.dataId = dataId;
	}
	public Integer getDataInputNum() {
		return this.dataInputNum;
	}
	protected void setDATAInputNum(Integer dataInputNum) {
		this.dataInputNum = dataInputNum;
	}
	public Integer getDatainValueNum() {
		return this.datainValueNum;
	}
	protected void setDatainValueNum(Integer DatainValueNum) {
		this.datainValueNum = DatainValueNum;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CoDataInputValuePK)) {
			return false;
		}
		CoDataInputValuePK castOther = (CoDataInputValuePK)other;
		return 
			(this.dataId == castOther.dataId)
			&& (this.dataInputNum == castOther.dataInputNum)
			&& (this.datainValueNum == castOther.datainValueNum);
	}

	public int hashCode() {
		final Integer prime = 31;
		Integer hash = 17;
		hash = hash * prime + this.dataId;
		hash = hash * prime + this.dataInputNum;
		hash = hash * prime + this.datainValueNum;
		
		return hash;
	}

	@Override
	public String toString() {
		return String.format("%s-%s-%s", this.getDataId(), this.getDataInputNum(), this.getDatainValueNum());
	}
}