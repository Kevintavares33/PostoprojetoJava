package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Abastecimento;
import com.example.demo.repository.AbastecimentoRepository;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;

    @Autowired
    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public Abastecimento createAbastecimento(Abastecimento abastecimento) {
        validateAbastecimento(abastecimento);
        calcularImpostoETotalPago(abastecimento);
        return abastecimentoRepository.save(abastecimento);
    }

    public Abastecimento updateAbastecimento(Long id, Abastecimento abastecimento) {
        validateAbastecimento(abastecimento);

        Abastecimento existingAbastecimento = abastecimentoRepository.findById(id)
                .orElse(null);

        if (existingAbastecimento == null) {
            return null;
        }

        existingAbastecimento.setValorLitro(abastecimento.getValorLitro());
        existingAbastecimento.setQuantidadeLitros(abastecimento.getQuantidadeLitros());
        calcularImpostoETotalPago(existingAbastecimento);

        return abastecimentoRepository.save(existingAbastecimento);
    }

    public void deleteAbastecimento(Long id) {
        abastecimentoRepository.deleteById(id);
    }

    public List<Abastecimento> getAllAbastecimentos() {
        return abastecimentoRepository.findAll();
    }

    public Abastecimento getAbastecimentoById(Long id) {
        return abastecimentoRepository.findById(id).orElse(null);
    }

    private void validateAbastecimento(Abastecimento abastecimento) {
        Objects.requireNonNull(abastecimento, "O objeto de abastecimento não pode ser nulo");
        // Adicione outras validações conforme necessário
    }

    private void calcularImpostoETotalPago(Abastecimento abastecimento) {
        double valorAbastecido = abastecimento.getQuantidadeLitros() * abastecimento.getValorLitro();
        double imposto = valorAbastecido * 0.13; // Imposto de 13%
        double totalPago = valorAbastecido + imposto;

        abastecimento.setImposto(imposto);
        abastecimento.setTotalPago(totalPago);
    }
}
