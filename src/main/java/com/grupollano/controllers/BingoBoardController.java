package com.grupollano.controllers;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupollano.model.entityplay.BingoBoard;
import com.grupollano.model.entityuser.Usuario;
import com.grupollano.repo.entityuser.IUsuarioDao;
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

	@Autowired(required = true)
	private BingoBoardServicesImp bingoBoardServices;
	@Autowired
	private UsuarioServicesImp usuarioServices;
	
	@PreAuthorize("hasAnyRole('Admin11','superusuario11')")
	@GetMapping(path = { "/bingo_board", "/" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<BingoBoard> bingoBoard(@RequestParam(name = "page", defaultValue = "0") int page,
			Authentication authentication, HttpServletRequest request) {

		if (authentication != null) {
			System.out.println("usuario controller ===> " + authentication.getName());
		}
		
		if(hasRole("Admin")) {
			System.out.println("Accedio");
		}
		else {
			System.out.println("no tiene Acceso ");
		}
		
		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request,"");
		if(securityContext.isUserInRole("Admin")) {

			System.out.println("SecurityContextHolderAwareRequestWrapper Accedio");
		}else {

			System.out.println("SecurityContextHolderAwareRequestWrapper NO Accedio");
		}

		Pageable pageableRequest = PageRequest.of(page, 10);
		Page<BingoBoard> bindBoardRequest = this.bingoBoardServices.findAll(pageableRequest);

		// PaginetorRender<BingoBoard> paginetor = new
		// PaginetorRender<>(bindBoardRequest) ;
		return bindBoardRequest;
	}

	@GetMapping(path = "/bingo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BingoBoard> bingoBoard2(@RequestParam(name = "page", defaultValue = "0") int page) {

		return this.bingoBoardServices.findAll();
	}

	@GetMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> bingoBoard2() {
		return this.usuarioServices.findAll();
	}

	public boolean hasRole(String role) {
		SecurityContext securityContext = SecurityContextHolder.getContext();

		if (securityContext == null) {
			return false;
		}

		Authentication authentication = securityContext.getAuthentication();

		if (authentication == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> autorice = authentication.getAuthorities();
		return autorice.contains(new SimpleGrantedAuthority(role));
		/*for (GrantedAuthority authority : autorice) {
			if(role.equals(authority.getAuthority())) {
				return true;
			}
		}
		return false;
		*/
	}

}
