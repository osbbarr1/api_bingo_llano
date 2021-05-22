package com.grupollano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupollano.model.entityplay.BingoBoard;
import com.grupollano.repo.entityplay.IBingoBoardDao;



@Service
public class BingoBoardServicesImp implements IBingoBoardServices{

	@Autowired(required=true)
	private IBingoBoardDao bingoBoardDao;
	
	@Transactional(readOnly = true)
	public Page<BingoBoard> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return bingoBoardDao.findAll(page);
	}

	public List<BingoBoard> findAll() {
		// TODO Auto-generated method stub
		return (List<BingoBoard>) bingoBoardDao.findAll();
	}

}
