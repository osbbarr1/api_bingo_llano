package com.grupollano.model.entityplay;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "bingo_param_board", schema = "public")
public class BingoBoard  {

	@Id
	@Column(name = "board_id")
	private Long id;
	
	
	@Column(name="board_numbers")
	@Type(type = "com.grupollano.util.GenericUserTypeIntegerArray")
	private Integer[] boardNumbers;

	@Column(name = "status")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Integer[] getBoardNumbers() {
		return boardNumbers;
	}

	public void setBoardNumbers(Integer[] boardNumbers) {
		this.boardNumbers = boardNumbers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
