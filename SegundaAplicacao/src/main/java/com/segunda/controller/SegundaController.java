package com.segunda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivo")

public class SegundaController {
	
	@GetMapping
	public String objetivo() {
		
		//tentativa de utilizar html para apresentação da saída usando o navegador e preview no Postman.
		return " <br> " + 
				" <strong> Objetivos de aprendizagem para esta semana na Generation: </strong>" +
				" <br> " + 
				" <br> " + 
				" <strong> MySQL: </strong> aprender sobre o banco de dados (quais comandos, como manipular os dados, etc) e desenvolver o MER e o DER." +
				" <br> " +
				" <br> " + 
				"<strong> Spring Tool: </strong> aprender sobre esta ferramenta, sobre injeção de dependências e as camadas: Model, Repository, Controller. " +
				" <br> " +
				" <br> " + 
				"<strong> Projeto Integrador: </strong> realizar as tasks solicitadas juntamente com a equipe 04. ";
	}

}
