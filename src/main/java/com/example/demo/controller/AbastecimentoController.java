package com.example.demo.controller;

import com.example.demo.model.Abastecimento;
import com.example.demo.service.AbastecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abastecimentos")
public class AbastecimentoController {
    private final AbastecimentoService abastecimentoService;

    @Autowired
    public AbastecimentoController(AbastecimentoService abastecimentoService) {
        this.abastecimentoService = abastecimentoService;
    }

    @GetMapping
    public ResponseEntity<List<Abastecimento>> getAllAbastecimentos() {
        List<Abastecimento> abastecimentos = abastecimentoService.getAllAbastecimentos();
        return new ResponseEntity<>(abastecimentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abastecimento> getAbastecimentoById(@PathVariable Long id) {
        Abastecimento abastecimento = abastecimentoService.getAbastecimentoById(id);
        if (abastecimento != null) {
            return new ResponseEntity<>(abastecimento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Abastecimento> createAbastecimento(@RequestBody Abastecimento abastecimento) {
        Abastecimento createdAbastecimento = abastecimentoService.createAbastecimento(abastecimento);
        return new ResponseEntity<>(createdAbastecimento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abastecimento> updateAbastecimento(@PathVariable Long id,
            @RequestBody Abastecimento abastecimento) {
        Abastecimento updatedAbastecimento = abastecimentoService.updateAbastecimento(id, abastecimento);
        if (updatedAbastecimento != null) {
            return new ResponseEntity<>(updatedAbastecimento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbastecimento(@PathVariable Long id) {
        boolean deleted = abastecimentoService.deleteAbastecimento(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
