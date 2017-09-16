package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

@Controller
public class ConvidadosController {

	/**
	 * Repare que com @Autowired, podemos injetar o repositório no controller, e
	 * isso nos livra da preocupação de como receber esse objeto na classe
	 */
	@Autowired
	private Convidados convidados;

	@GetMapping("/convidados")
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		// Esse objeto é chamado de command object, que é o objeto que modela o formulário
		modelAndView.addObject(new Convidado());
		return modelAndView;

	}

	@PostMapping("/convidados")
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		
		/**
		 * ao invés de retornarmos o nome da view que queremos renderizar,
		 * podemos retornar uma URL para redirecionar a requisição usando
		 * “redirect:” na String.
		 */
		return "redirect:/convidados";
	}
}
