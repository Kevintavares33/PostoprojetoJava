package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Abastecimento;
import com.example.demo.service.AbastecimentoService;

@RestController
@SpringBootApplication
public class ControledeAbastecimentoApplication {

	@Autowired
	private AbastecimentoService abastecimentoService;

	public static void main(String[] args) {
		SpringApplication.run(ControledeAbastecimentoApplication.class, args);
		System.out.println("Sou EU Kevin! 2X3=6");
	}

	@PostMapping("/abastecimento")
	public ResponseEntity<String> criarAbastecimento(@RequestBody Abastecimento abastecimento) {
		abastecimentoService.salvarAbastecimento(abastecimento);
		return ResponseEntity.ok("Abastecimento criado com sucesso!");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erro interno do servidor: " + e.getMessage());
	}
}
