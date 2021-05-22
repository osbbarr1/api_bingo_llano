package com.grupollano.repo.entityplay;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.grupollano.model.entityplay.BingoBoard;

public interface IBingoBoardDao extends PagingAndSortingRepository<BingoBoard, Long>{
	
}
