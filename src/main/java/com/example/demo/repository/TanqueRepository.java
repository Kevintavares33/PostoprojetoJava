package com.example.demo.repository;

import com.example.demo.model.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TanqueRepository extends JpaRepository<Tanque, Long> {

    // Se necessário, adicione métodos de consulta personalizados aqui
}
