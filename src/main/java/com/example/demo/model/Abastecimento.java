package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePosto;
    private double valorLitro;
    private double quantidadeLitros;
    private double totalPago;
    private double imposto;

    public Abastecimento(String nomePosto, double valorLitro, double quantidadeLitros) {
        this.nomePosto = nomePosto;
        this.valorLitro = valorLitro;
        this.quantidadeLitros = quantidadeLitros;
        this.calcularImposto();
        this.totalPago = (this.valorLitro * this.quantidadeLitros) + this.imposto;
    }

    // getters e setters

    private void calcularImposto() {
        this.imposto = (this.valorLitro * this.quantidadeLitros) * 0.13; // 13% de imposto
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", nomePosto='" + nomePosto + '\'' +
                ", valorLitro=" + valorLitro +
                ", quantidadeLitros=" + quantidadeLitros +
                ", totalPago=" + totalPago +
                ", imposto=" + imposto +
                '}';
    }

    public String getCombustivel() {
        return null;
    }

    public double getTotalPago() {
        return 0;
    }

    public Tanque getTanque() {
        return null;
    }

    public Object getBomba() {
        return null;
    }

    public Object getDataAbastecimento() {
        return null;
    }
}
