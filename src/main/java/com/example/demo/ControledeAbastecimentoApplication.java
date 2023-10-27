package com.example.demo;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.ComponentScan;
import com.example.demo.model.Abastecimento;
import com.example.demo.service.AbastecimentoService;

@RestController
@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class ControledeAbastecimentoApplication {

	private static final Logger logger = LoggerFactory.getLogger(ControledeAbastecimentoApplication.class);

	@Autowired
	private AbastecimentoService AbastecimentoService;

	public static void main(String[] args) {
		SpringApplication.run(ControledeAbastecimentoApplication.class, args);
	}

	@PostMapping("/abastecimento")
	public ResponseEntity<String> criarAbastecimento(@Valid @RequestBody Abastecimento abastecimento) {
		AbastecimentoService.createAbastecimento(abastecimento);
		return ResponseEntity.status(HttpStatus.CREATED).body("Abastecimento criado com sucesso!");
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		StringBuilder errorMsg = new StringBuilder("Erro de validação: ");
		ex.getBindingResult().getAllErrors().forEach(error -> errorMsg.append(error.getDefaultMessage()).append("; "));
		logger.error("Erro de validação: {}", errorMsg.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg.toString());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		logger.error("Erro interno do servidor: ", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erro interno do servidor: " + e.getMessage());
	}
}
