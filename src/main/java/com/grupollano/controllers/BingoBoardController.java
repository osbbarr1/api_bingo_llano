package com.grupollano.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupollano.model.entityplay.BingoBoard;
import com.grupollano.model.entityuser.Usuario;
import com.grupollano.service.BingoBoardServicesImp;
import com.grupollano.service.UsuarioServicesImp;


/**
 * 
 * @Autor oabaquero
 * 
 */

@CrossOrigin
@RestController
@RequestMapping("/bingo/v1")
public class BingoBoardController {
	
	@Autowired(required=true)
	private BingoBoardServicesImp bingoBoardServices; 
	
	@Autowired(required=true)
	private UsuarioServicesImp usuarioServices;
	
	@GetMapping(path="/bingo_board" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BingoBoard> bingoBoard(@RequestParam(name="page", defaultValue = "0") int page) {
		
		Pageable pageableRequest = PageRequest.of(page, 10);
		Page<BingoBoard> bindBoardRequest = this.bingoBoardServices.findAll(pageableRequest);

	//	PaginetorRender<BingoBoard> paginetor = new PaginetorRender<>(bindBoardRequest) ;
		return bindBoardRequest;
	}
	
	@GetMapping(path="/bingo" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BingoBoard> bingoBoard2(@RequestParam(name="page", defaultValue = "0") int page) {
	
		
		return this.bingoBoardServices.findAll();
	}
	
	@GetMapping(path="/usuarios" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> getUsuarios(@RequestParam(name="page", defaultValue = "0") int page) {
	
		
		return this.usuarioServices.findAll();
	}
	

	

}
