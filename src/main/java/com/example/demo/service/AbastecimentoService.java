package com.example.demo.service;

import com.example.demo.model.Abastecimento;
import com.example.demo.repository.AbastecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;

    @Autowired
    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public void salvarAbastecimento(Abastecimento abastecimento) {
        double imposto = calcularImposto(abastecimento.getValorLitro(), abastecimento.getQuantidadeLitros());
        double totalPago = abastecimento.getValorLitro() * abastecimento.getQuantidadeLitros() + imposto;

        abastecimento.setImposto(imposto);
        abastecimento.setTotalPago(totalPago);

        abastecimentoRepository.save(abastecimento);
    }

    public List<Abastecimento> buscarTodosAbastecimentos() {
        return abastecimentoRepository.findAll();
    }

    public Abastecimento buscarAbastecimentoPorId(Long id) {
        return abastecimentoRepository.findById(id).orElse(null);
    }

    public void deletarAbastecimentoPorId(Long id) {
        abastecimentoRepository.deleteById(id);
    }

    private double calcularImposto(double valorLitro, double quantidadeLitros) {
        double valorAbastecido = valorLitro * quantidadeLitros;
        return valorAbastecido * 0.13; // 13% de imposto
    }
}
