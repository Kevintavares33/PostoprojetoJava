package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.DTO.RelatorioAbastecimentoDTO;
import com.example.demo.repository.AbastecimentoRepository;
import com.example.demo.model.Abastecimento;
import com.example.demo.model.Tanque;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    private final AbastecimentoRepository abastecimentoRepository;

    public RelatorioService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public List<RelatorioAbastecimentoDTO> gerarRelatorioAbastecimentos() {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findAll();

        return abastecimentos.stream()
                .map(this::mapToRelatorioAbastecimentoDTO)
                .collect(Collectors.toList());
    }

    private RelatorioAbastecimentoDTO mapToRelatorioAbastecimentoDTO(Abastecimento abastecimento) {
        String dia = abastecimento.getDataAbastecimento().toString(); // Supondo que a data esteja disponível no objeto
                                                                      // Abastecimento
        Tanque tanque = abastecimento.getTanque();
        String nomeTanque = tanque.getNome();
        String bomba = String.valueOf(((Object) abastecimento.getBomba()).getNumero()); // Supondo que o número da bomba
                                                                                        // seja um
        // inteiro
        String combustivel = abastecimento.getCombustivel(); // Supondo que o tipo de combustível seja uma string
        double valor = abastecimento.getTotalPago(); // Supondo que o valor total pago esteja disponível no objeto
                                                     // Abastecimento

        return new RelatorioAbastecimentoDTO(dia, nomeTanque, bomba, combustivel, valor);
    }
}
