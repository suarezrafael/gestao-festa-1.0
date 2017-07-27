package com.algaworks.festa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConvidadosController {
	
	// Indica que atraves da url ser aberta a view  LstaConvidados
	@GetMapping("/convidados")
	public String listar(){
		return "ListaConvidados";
	}

}	
