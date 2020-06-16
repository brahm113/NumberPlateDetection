package com.NumberPlateDetection.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="offence")
public class OffenceModel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="offenceId")
	private int offenceId;
	
	@Column(name="offenceName")
	private String offenceName;
	
	@Column(name="deleteStatus")
	private String deletestatus;
	
	public String getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(String deletestatus) {
		this.deletestatus = deletestatus;
	}

	public int getOffenceId() {
		return offenceId;
	}

	public void setOffenceId(int offenceId) {
		this.offenceId = offenceId;
	}

	public String getOffenceName() {
		return offenceName;
	}

	public void setOffenceName(String offenceName) {
		this.offenceName = offenceName;
	}

}
