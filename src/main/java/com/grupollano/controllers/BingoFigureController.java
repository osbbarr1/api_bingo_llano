package com.grupollano.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupollano.model.entityplay.BingoFigura;
import com.grupollano.service.BingoFiguraServicesImp;

@CrossOrigin
@RestController
@RequestMapping("/bingo/v1")
public class BingoFigureController {

	@Autowired
	private BingoFiguraServicesImp bingoFiguraServices;

	/**
	 * Consulta las Figuras de los bingos del sistema
	 * @return an instance of java.lang.String
	 */
	@GetMapping(path = { "/bingo_figura" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BingoFigura> getFiguras() {
		return bingoFiguraServices.findAll();

	}
}
