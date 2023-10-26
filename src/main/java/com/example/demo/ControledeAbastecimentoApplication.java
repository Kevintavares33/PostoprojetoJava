package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Abastecimento;

import com.example.demo.service.AbastecimentoService;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@SpringBootApplication
public class ControledeAbastecimentoApplication {

	private static final Logger logger = LoggerFactory.getLogger(ControledeAbastecimentoApplication.class);

	@Autowired
	private AbastecimentoService AbastecimentoService;

	public static void main(String[] args) {
		SpringApplication.run(ControledeAbastecimentoApplication.class, args);
	}

	@PostMapping("/abastecimento")
	public ResponseEntity<String> criarAbastecimento(@Validated @RequestBody Abastecimento abastecimento) {
		AbastecimentoService.salvarAbastecimento(abastecimento);
		return ResponseEntity.ok("Abastecimento criado com sucesso!");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		logger.error("Erro interno do servidor: ", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erro interno do servidor: " + e.getMessage());
	}
}
