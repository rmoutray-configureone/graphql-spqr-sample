package com.company.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CO_Data_INPUT_ATTRIBUTE database table.
 * 
 */
@Entity
@Table(name="CO_DATA_INPUT_ATTRIBUTE")
@NamedQuery(name="CoDataInputAttribute.findAll", query="SELECT c FROM CoDataInputAttribute c")
public class CoDataInputAttribute implements Serializable {
	private static final Long serialVersionUID = 1L;

	@EmbeddedId
	private CoDataInputAttributePK id;

	@Column(name="ATTR_VALUE", length=4000)
	private String attrValue;

	public CoDataInputAttribute() {
	}

	public CoDataInputAttributePK getId() {
		return this.id;
	}

	protected void setId(CoDataInputAttributePK id) {
		this.id = id;
	}

	public String getAttrValue() {
		return this.attrValue;
	}

	protected void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

}