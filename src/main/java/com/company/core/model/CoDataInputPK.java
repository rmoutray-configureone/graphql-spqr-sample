package com.company.core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CO_Data_INPUT database table.
 * 
 */
@Embeddable
public class CoDataInputPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final Long serialVersionUID = 1L;

	@Column(name="DATA_ID", unique=true, nullable=false)
	private Integer dataId;

	@Column(name="DATA_INPUT_NUM", unique=true, nullable=false)
	private Integer dataInputNum;

	public CoDataInputPK() {
	}
        
        public CoDataInputPK(int dataId, int dataInputNum) {
            this.dataId = dataId;
            this.dataInputNum = dataInputNum;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CoDataInputPK)) {
			return false;
		}
		CoDataInputPK castOther = (CoDataInputPK)other;
		return 
			(this.dataId == castOther.dataId)
			&& (this.dataInputNum == castOther.dataInputNum);
	}

	public int hashCode() {
		final Integer prime = 31;
		Integer hash = 17;
		hash = hash * prime + this.dataId;
		hash = hash * prime + this.dataInputNum;
		
		return hash;
	}
        
        @Override
        public String toString() {
            return this.dataId.toString() + "-" + this.dataInputNum.toString();
        }
}