package com.example.demo.service;

import com.example.demo.model.Abastecimento;
import com.example.demo.model.Bomba;
import com.example.demo.model.Tanque;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {

    public String gerarRelatorio(Abastecimento abastecimento) {
        StringBuilder relatorio = new StringBuilder();

        relatorio.append("Relatório de Abastecimento\n");
        relatorio.append("Data: ").append(abastecimento.getData()).append("\n");
        relatorio.append("Número do Abastecimento: ").append(abastecimento.getNumero()).append("\n");

        Tanque tanque = abastecimento.getTanque();
        relatorio.append("Tanque: ").append(tanque.getNome()).append("\n");

        Bomba bomba = abastecimento.getBomba();
        relatorio.append("Bomba: ").append(bomba.getNumero()).append("\n");

        relatorio.append("Combustível: ").append(abastecimento.getCombustivel()).append("\n");
        relatorio.append("Quantidade de Litros: ").append(abastecimento.getQuantidadeLitros()).append("\n");
        relatorio.append("Valor por Litro: ").append(abastecimento.getValorLitro()).append("\n");
        relatorio.append("Total Pago: ").append(abastecimento.getTotalPago()).append("\n");
        relatorio.append("Imposto: ").append(abastecimento.getImposto()).append("\n");

        return relatorio.toString();
    }
}
