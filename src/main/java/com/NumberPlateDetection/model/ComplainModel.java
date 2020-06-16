package com.NumberPlateDetection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "complain")
public class ComplainModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int complainId;

	@Column
	private String subject;

	@Column
	private String description;

	@Column
	private String replyDescription;

	@Column
	private String complainStatus;

	@Column
	private String complainDate;

	@Column
	private String complainTime;

	@ManyToOne
	private LoginModel fromId;

	@ManyToOne
	private LoginModel toId;

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	
	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReplyDescription() {
		return replyDescription;
	}

	public void setReplyDescription(String replyDescription) {
		this.replyDescription = replyDescription;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}

	public String getComplainDate() {
		return complainDate;
	}

	public void setComplainDate(String complainDate) {
		this.complainDate = complainDate;
	}

	public String getComplainTime() {
		return complainTime;
	}

	public void setComplainTime(String complainTime) {
		this.complainTime = complainTime;
	}

	public LoginModel getFromId() {
		return fromId;
	}

	public void setFromId(LoginModel fromId) {
		this.fromId = fromId;
	}

	public LoginModel getToId() {
		return toId;
	}

	public void setToId(LoginModel toId) {
		this.toId = toId;
	}

}
