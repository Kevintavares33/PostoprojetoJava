package com.example.demo.controller;

import com.example.demo.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.demo.DTO.RelatorioAbastecimentoDTO;
import com.example.demo.model.Abastecimento;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Abastecimento;

import java.util.List;

@RestController
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/gerarRelatorio")
    public void gerarRelatorioAbastecimentos() {

        Abastecimento abastecimento = new Abastecimento("Posto A", 0, null, null, null, 4.5, 50, 0, 0);

        relatorioService.gerarRelatorio(abastecimento);
    }
}