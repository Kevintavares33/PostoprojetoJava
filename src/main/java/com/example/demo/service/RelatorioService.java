package com.example.demo.service;

import com.example.demo.dto.RelatorioAbastecimentodto;
import com.example.demo.model.Abastecimento;
import com.example.demo.repository.AbastecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioService {
    private final AbastecimentoRepository abastecimentoRepository;

    @Autowired
    public RelatorioService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public List<RelatorioAbastecimentodto> gerarRelatorio() {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findAll();
        Map<String, RelatorioAbastecimentodto> relatorioMap = new HashMap<>();

        for (Abastecimento abastecimento : abastecimentos) {
            String chave = abastecimento.getData() + "_" +
                    abastecimento.getTanque().getNome() + "_" +
                    abastecimento.getBomba().getNumero() + "_" +
                    abastecimento.getCombustivel();

            RelatorioAbastecimentodto relatorioDto = relatorioMap.get(chave);
            if (relatorioDto == null) {
                relatorioDto = new RelatorioAbastecimentodto();
                relatorioDto.setDia(abastecimento.getData());
                relatorioDto.setTanque(abastecimento.getTanque().getNome());
                relatorioDto.setBomba(Integer.toString(abastecimento.getBomba().getNumero()));
                relatorioDto.setCombustivel(abastecimento.getCombustivel());
                relatorioDto.setValor(0.0);
            }

            relatorioDto.setValor(relatorioDto.getValor() + abastecimento.getTotalPago());
            relatorioMap.put(chave, relatorioDto);
        }

        return new ArrayList<>(relatorioMap.values());
    }
}
