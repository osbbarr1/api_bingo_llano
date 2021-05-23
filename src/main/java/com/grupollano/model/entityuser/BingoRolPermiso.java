package com.grupollano.model.entityuser;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bingo_rol_permission", schema = "public")
public class BingoRolPermiso  implements Serializable {

	@Id
	@Column(name="id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = true)
	private BingoRol rol_id;
	
	@OneToOne
	@JoinColumn(name = "permission_id", referencedColumnName = "permission_id", nullable = true)
	private BingoPermiso permission_id;
	
	@Column(name="status")
	private String status;

	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}
	
	@Column(name="created_by")
	private String createdBy;
	

	public BingoRol getRol_id() {
		return rol_id;
	}


	public void setRol_id(BingoRol rol_id) {
		this.rol_id = rol_id;
	}


	public BingoPermiso getPermission_id() {
		return permission_id;
	}


	public void setPermission_id(BingoPermiso permission_id) {
		this.permission_id = permission_id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	
	
	
}
