package com.qtechlabs.employeemanagement.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * This class act as common attributes class for Employee table which saves data
 * corresponding to Employee and shares creation , update and deletion of time
 * for required operations
 */

public class EmployeeCommonAttributesDTO implements Serializable {

	private static final long serialVersionUID = 495359986969404062L;

	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

}
