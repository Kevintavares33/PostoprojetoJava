package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String posto;
    private String data;

    @OneToOne
    private Tanque tanque;

    @OneToOne
    private Bomba bomba;

    private String combustivel;
    private double quantidadeLitros;
    private double valorLitro;
    private double totalPago;
    private double imposto;

    public Abastecimento() {
    }

    public Abastecimento(String posto, String data, Tanque tanque, Bomba bomba, String combustivel,
            double quantidadeLitros, double valorLitro) {
        this.posto = posto;
        this.data = data;
        this.tanque = tanque;
        this.bomba = bomba;
        this.combustivel = combustivel;
        this.quantidadeLitros = quantidadeLitros;
        this.valorLitro = valorLitro;
        calcularImposto();
        calcularTotalPago();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public Bomba getBomba() {
        return bomba;
    }

    public void setBomba(Bomba bomba) {
        this.bomba = bomba;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public double getQuantidadeLitros() {
        return quantidadeLitros;
    }

    public void setQuantidadeLitros(double quantidadeLitros) {
        this.quantidadeLitros = quantidadeLitros;
        calcularImposto();
        calcularTotalPago();
    }

    public double getValorLitro() {
        return valorLitro;
    }

    public void setValorLitro(double valorLitro) {
        this.valorLitro = valorLitro;
        calcularImposto();
        calcularTotalPago();
    }

    public double getTotalPago() {
        return totalPago;
    }

    public double getImposto() {
        return imposto;
    }

    private void calcularImposto() {
        this.imposto = this.quantidadeLitros * this.valorLitro * 0.13; // Imposto de 13%
    }

    private void calcularTotalPago() {
        this.totalPago = this.quantidadeLitros * this.valorLitro + this.imposto;

    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

}
