package com.grupollano.model.entityplay;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "bingo_param_figure", schema = "public")
public class BingoFigura implements Serializable {

	@Id
	@Column(name = "figure_id")
	private Long id;

	@Column(name = "group_figure_id")
	private Long groupFigureId;

	@Column(name = "figure_name")
	private String figureName;

	@Column(name = "positions_winner")
	@Type(type = "com.grupollano.util.GenericUserArrayBooleanArray")
	private Boolean[] positionsWinner;

	@Column(name = "status")
	private String status;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}

	@Column(name = "used")
	private boolean used;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupFigureId() {
		return groupFigureId;
	}

	public void setGroupFigureId(Long groupFigureId) {
		this.groupFigureId = groupFigureId;
	}

	public String getFigureName() {
		return figureName;
	}

	public void setFigureName(String figureName) {
		this.figureName = figureName;
	}

	public Boolean[] getPositionsWinner() {
		return positionsWinner;
	}

	public void setPositionsWinner(Boolean[] positionsWinner) {
		this.positionsWinner = positionsWinner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	private static final long serialVersionUID = 1L;
}
