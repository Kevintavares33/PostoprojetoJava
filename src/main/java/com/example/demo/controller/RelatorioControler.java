package com.example.demo.controller;

import com.example.demo.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/abastecimentos")
    public ResponseEntity<List<RelatorioAbastecimentoDTO>> gerarRelatorioAbastecimentos() {
        List<RelatorioAbastecimentoDTO> relatorio = relatorioService.gerarRelatorioAbastecimentos();
        return ResponseEntity.ok(relatorio);
    }
}
