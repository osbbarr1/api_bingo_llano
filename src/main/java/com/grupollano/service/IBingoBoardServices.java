package com.grupollano.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.grupollano.model.entityplay.BingoBoard;



public interface IBingoBoardServices {
	
	public Page<BingoBoard> findAll(Pageable page);
	
	public List<BingoBoard> findAll();

}
