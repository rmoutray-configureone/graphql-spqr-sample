package com.company.core.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CO_Data_INPUT_ATTRIBUTE database table.
 * 
 */
@Embeddable
public class CoDataInputAttributePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final Long serialVersionUID = 1L;

	@Column(name="DATA_ID", unique=true, nullable=false)
	private Integer dataId;

	@Column(name="ATTRIBUTE_ID", unique=true, nullable=false)
	private Integer attributeId;

	@Column(name="DATA_INPUT_NUM", unique=true, nullable=false)
	private Integer dataInputNum;

	@Column(name="DATA_INPUT_VAL_NUM", unique=true, nullable=false)
	private Integer dataInputValNum;

	@Column(name="SEQ_NUM", unique=true, nullable=false)
	private Short seqNum;

	public CoDataInputAttributePK() {
	}
        
        public CoDataInputAttributePK(int dataId, int dataInputNum, int DatainValueNum, int seqNum) {
		this.dataId = dataId;
		this.dataInputNum = dataInputNum;
		this.dataInputValNum = DatainValueNum;
                this.seqNum = this.seqNum;
	}
        
	public Integer getDataId() {
		return this.dataId;
	}
	protected void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	public Integer getAttributeId() {
		return this.attributeId;
	}
	protected void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}
	public Integer getDataInputNum() {
		return this.dataInputNum;
	}
	protected void setDATAInputNum(Integer dataInputNum) {
		this.dataInputNum = dataInputNum;
	}
	public Integer getDataInputValNum() {
		return this.dataInputValNum;
	}
	protected void setDATAInputValNum(Integer dataInputValNum) {
		this.dataInputValNum = dataInputValNum;
	}
	public Short getSeqNum() {
		return this.seqNum;
	}
	protected void setSeqNum(Short seqNum) {
		this.seqNum = seqNum;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CoDataInputAttributePK)) {
			return false;
		}
		CoDataInputAttributePK castOther = (CoDataInputAttributePK)other;
		return 
			(this.dataId == castOther.dataId)
			&& (this.attributeId == castOther.attributeId)
			&& (this.dataInputNum == castOther.dataInputNum)
			&& (this.dataInputValNum == castOther.dataInputValNum)
			&& (this.seqNum == castOther.seqNum);
	}

	public int hashCode() {
		final Integer prime = 31;
		Integer hash = 17;
		hash = hash * prime + this.dataId;
		hash = hash * prime + this.attributeId;
		hash = hash * prime + this.dataInputNum;
		hash = hash * prime + this.dataInputValNum;
		hash = hash * prime + ((int) this.seqNum);
		
		return hash;
	}
        
        @Override
	public String toString() {
		return String.format("%s-%s-%s-%s", this.getDataId(), this.getDataInputNum(), this.getDataInputValNum(), this.getSeqNum());
	}
}