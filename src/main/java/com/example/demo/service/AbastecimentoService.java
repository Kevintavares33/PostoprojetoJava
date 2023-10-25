package com.example.demo.service;

import com.example.demo.model.Abastecimento;
import com.example.demo.model.Bomba;
import com.example.demo.model.Tanque;
import com.example.demo.repository.AbastecimentoRepository;
import com.example.demo.repository.BombaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;
    private final BombaRepository bombaRepository;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository, BombaRepository bombaRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
        this.bombaRepository = bombaRepository;
    }

    public List<Abastecimento> getAllAbastecimentos() {
        return this.abastecimentoRepository.findAll();
    }

    public Abastecimento getAbastecimentoById(Long id) {
        return this.abastecimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abastecimento não encontrado"));
    }

    public Abastecimento createAbastecimento(Abastecimento abastecimento) {
        Bomba bomba = this.bombaRepository.findById(abastecimento.getBombaId())
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));

        Tanque tanque = bomba.getTanque();

        double imposto = calcularImposto(abastecimento.getValorLitro(), abastecimento.getQuantidadeLitros());
        double totalPago = abastecimento.getValorLitro() * abastecimento.getQuantidadeLitros() + imposto;

        abastecimento.setImposto(imposto);
        abastecimento.setTotalPago(totalPago);
        abastecimento.setTanque(tanque);

        return this.abastecimentoRepository.save(abastecimento);
    }

    public Abastecimento updateAbastecimento(Long id, Abastecimento abastecimento) {
        // Verifica se o abastecimento existe
        this.getAbastecimentoById(id);

        // Atualiza os campos do abastecimento existente com os novos valores
        abastecimento.setId(id);
        Bomba bomba = this.bombaRepository.findById(abastecimento.getBombaId())
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));
        Tanque tanque = bomba.getTanque();
        double imposto = calcularImposto(abastecimento.getValorLitro(), abastecimento.getQuantidadeLitros());
        double totalPago = abastecimento.getValorLitro() * abastecimento.getQuantidadeLitros() + imposto;
        abastecimento.setImposto(imposto);
        abastecimento.setTotalPago(totalPago);
        abastecimento.setTanque(tanque);

        return this.abastecimentoRepository.save(abastecimento);
    }

    public void deleteAbastecimento(Long id) {
        // Verifica se o abastecimento existe
        this.getAbastecimentoById(id);

        // Deleta o abastecimento pelo ID
        this.abastecimentoRepository.deleteById(id);
    }

    private double calcularImposto(double valorLitro, double quantidadeLitros) {
        double valorAbastecido = valorLitro * quantidadeLitros;
        return valorAbastecido * 0.13; // 13% de imposto
    }
}
