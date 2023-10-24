package com.example.demo.repository;

import com.example.demo.model.Bomba;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BombaRepository extends JpaRepository<Bomba, Long> {

    // Se necessário, adicione métodos de consulta personalizados aqui
}
