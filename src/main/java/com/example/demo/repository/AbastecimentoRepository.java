package com.example.demo.repository;

import com.example.demo.model.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    // Métodos de consulta personalizados, se necessário
}
