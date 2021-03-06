package com.rarm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity<ID> {

	@Version
	private Long version;
	
	@Column(name="created_date", nullable=false)
	private Date createdDate;
	
	@Column(name="last_modified_date", nullable=false)
	private Date last_modified_Date;
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public abstract ID getId();

	public Date getLast_modified_Date() {
		return last_modified_Date;
	}

	public Long getVersion() {
		return version;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setLast_modified_Date(Date last_modified_Date) {
		this.last_modified_Date = last_modified_Date;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	@PrePersist
	public void prePersist(){
		
		this.createdDate = new Date();
		this.last_modified_Date = new Date();
	}
	
	@PreUpdate
	public void preUpdate(){
		
		this.last_modified_Date = new Date();
	}
}
