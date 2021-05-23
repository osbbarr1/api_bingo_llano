package com.grupollano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupollano.model.entityplay.BingoFigura;
import com.grupollano.repo.entityplay.IBingoFigureDao;

@Service
public class BingoFiguraServicesImp implements IBingoFigura{
	
	@Autowired
	private IBingoFigureDao bingoFiguraDao;

	@Override
	public List<BingoFigura> findAll() {
		return bingoFiguraDao.findAll();
	}

	@Override
	public BingoFigura save(BingoFigura bingoFigura) {
		return bingoFiguraDao.save(bingoFigura);
		
	}

}
