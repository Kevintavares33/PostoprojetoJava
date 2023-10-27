package com.example.demo.repository;

import com.example.demo.model.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    // Métodos de consulta personalizados, se necessário
}