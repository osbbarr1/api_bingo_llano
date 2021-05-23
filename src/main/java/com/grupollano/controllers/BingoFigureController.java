package com.grupollano.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping(path = { "/bingo_figura" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public void upFigura(@RequestParam(name = "id", required = true) Long id,
			@RequestParam(name = "groupFigureId", required = true) Long groupFigureId,
			@RequestParam(name = "figureName", required = true) String figureName,
			@RequestParam(name = "positionsWinner", required = true) Boolean[] positionsWinner,
			@RequestParam(name = "status", required = true) String status,
			@RequestParam(name = "createdBy", required = true) Long createdBy,
			@RequestParam(name = "used", required = true) boolean used) {
		
		
		BingoFigura bingoFigura = new BingoFigura();
		bingoFigura.setId(id);
		bingoFigura.setGroupFigureId(groupFigureId);
		bingoFigura.setFigureName(figureName);
		bingoFigura.setPositionsWinner(positionsWinner);
		bingoFigura.setStatus(status);
		bingoFigura.setCreatedBy(createdBy);
		
		bingoFiguraServices.save(bingoFigura);
		
		System.out.println(positionsWinner);
	}
}
