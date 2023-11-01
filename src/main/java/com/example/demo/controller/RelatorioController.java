package com.example.demo.controller;

import com.example.demo.service.RelatorioService;
import com.example.demo.dto.RelatorioAbastecimentodto;
import com.example.demo.model.Abastecimento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/gerarRelatorio")
    public ResponseEntity<List<RelatorioAbastecimentodto>> gerarRelatorioAbastecimentos() {
        List<RelatorioAbastecimentodto> relatorio = relatorioService.gerarRelatorio();
        return ResponseEntity.ok(relatorio);
    }
}
