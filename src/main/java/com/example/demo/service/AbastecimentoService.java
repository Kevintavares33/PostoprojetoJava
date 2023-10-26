package com.example.demo.service;

import com.example.demo.model.Abastecimento;
import com.example.demo.repository.AbastecimentoRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public Abastecimento createAbastecimento(Abastecimento abastecimento) {
        abastecimento.calcularImposto();
        abastecimento.calcularTotalPago();
        return abastecimentoRepository.save(abastecimento);
    }

    public Abastecimento updateAbastecimento(Long id, Abastecimento abastecimento) {
        Abastecimento existingAbastecimento = abastecimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abastecimento não encontrado"));

        existingAbastecimento.setValorLitro(abastecimento.getValorLitro());
        existingAbastecimento.setQuantidadeLitros(abastecimento.getQuantidadeLitros());
        existingAbastecimento.calcularImposto();
        existingAbastecimento.calcularTotalPago();

        return abastecimentoRepository.save(existingAbastecimento);
    }

    public void deleteAbastecimento(Long id) {
        abastecimentoRepository.deleteById(id);
    }

    public void salvarAbastecimento(Abastecimento abastecimento) {
    }

    public List<Abastecimento> getAllAbastecimentos() {
        return null;
    }

    public Abastecimento getAbastecimentoById(Long id) {
        return null;
    }
}