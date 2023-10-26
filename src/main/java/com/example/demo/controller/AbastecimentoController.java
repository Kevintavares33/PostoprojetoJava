package com.example.demo.controller;

import com.example.demo.model.Abastecimento;
import com.example.demo.service.AbastecimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    public AbastecimentoController(AbastecimentoService abastecimentoService) {
        this.abastecimentoService = abastecimentoService;
    }

    @GetMapping
    public List<Abastecimento> getAllAbastecimentos() {
        return abastecimentoService.getAllAbastecimentos();
    }

    @GetMapping("/{id}")
    public Abastecimento getAbastecimentoById(@PathVariable Long id) {
        return abastecimentoService.getAbastecimentoById(id);
    }

    @PostMapping
    public Abastecimento createAbastecimento(@RequestBody Abastecimento abastecimento) {
        return abastecimentoService.createAbastecimento(abastecimento);
    }

    @PutMapping("/{id}")
    public Abastecimento updateAbastecimento(@PathVariable Long id, @RequestBody Abastecimento abastecimento) {
        return abastecimentoService.updateAbastecimento(id, abastecimento);
    }

    @DeleteMapping("/{id}")
    public void deleteAbastecimento(@PathVariable Long id) {
        abastecimentoService.deleteAbastecimento(id);
    }
}