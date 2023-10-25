package com.example.demo.repository;

import com.example.demo.model.Bomba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombaRepository extends JpaRepository<Bomba, Long> {
    // métodos personalizados, se houver
}
