package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;
import com.example.demo.dto.RelatorioAbastecimentodto;
import com.example.demo.model.Abastecimento;
import com.example.demo.repository.AbastecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {
    private final AbastecimentoRepository abastecimentoRepository;

    @Autowired
    public RelatorioService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public List<RelatorioAbastecimentodto> gerarRelatorio() {
        List<RelatorioAbastecimentodto> relatorio = new ArrayList<>();

        List<Abastecimento> abastecimentos = abastecimentoRepository.findAll();

        for (Abastecimento abastecimento : abastecimentos) {
            RelatorioAbastecimentodto relatoriodto = new RelatorioAbastecimentodto();
            relatoriodto.setDia(abastecimento.getData());
            relatoriodto.setTanque(abastecimento.getTanque().getNome());
            relatoriodto.setBomba(Integer.toString(abastecimento.getBomba().getNumero()));
            relatoriodto.setCombustivel(abastecimento.getCombustivel());
            relatoriodto.setValor(abastecimento.getTotalPago());

            relatorio.add(relatoriodto);
        }

        return relatorio;
    }
}
