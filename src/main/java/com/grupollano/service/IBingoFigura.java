package com.grupollano.service;

import java.util.List;

import com.grupollano.model.entityplay.BingoFigura;

public interface IBingoFigura {

	public List<BingoFigura> findAll();
	public BingoFigura save (BingoFigura bingoFigura);
}
