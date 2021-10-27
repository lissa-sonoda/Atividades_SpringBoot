package com.primeira.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidade")

public class PrimeiraController {
	
	@GetMapping
	public String habilidade() {
		
		//tentativa de utilizar html para apresentação da saída usando o navegador e preview no Postman.
		return " <br> " + 
				" <strong> As habilidades e mentalidades que utilizei para realizar essa atividade: </strong>" +
				" <br> " + 
				" <br> " + 
				" <strong> Persistência: </strong> esta mentalidade foi necessária, pois hoje a turma 35 da Generation aprendeu uma nova ferramenta (o Spring Tool)," +
				" <br> " + 
				"logo depois de aprender sobre o banco de dados MySQL. E está sendo bem puxado, mas não podemos desistir!!!  <strong> ^-^ </strong>" +
				" <br> " +
				" <br> " + 
				"<strong> Atenção aos detalhes: </strong> esta habilidade é bem importante para este novo aprendizado, pois precisamos estar atentos à como " +
				" <br> " + 
				"funciona esta ferramenta e também na hora de codar. Às vezes, algum erro é por conta de algo bem simples como a falta de um ' <strong> ; </strong> ' . ";
	}

}
