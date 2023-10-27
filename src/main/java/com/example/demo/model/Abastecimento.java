package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Abastecimento {
    @Id
    private int numero;
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

    public Abastecimento(String data, int numero, Tanque tanque, Bomba bomba, String combustivel,
            double quantidadeLitros, double valorLitro, double totalPago, double imposto) {
        this.data = data;
        this.numero = numero;
        this.tanque = tanque;
        this.bomba = bomba;
        this.combustivel = combustivel;
        this.quantidadeLitros = quantidadeLitros;
        this.valorLitro = valorLitro;
        this.totalPago = totalPago;
        this.imposto = imposto;
    }

    // Getters e setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
    }

    public double getValorLitro() {
        return valorLitro;
    }

    public void setValorLitro(double valorLitro) {
        this.valorLitro = valorLitro;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void calcularImposto() {
    }

    public void calcularTotalPago() {
    }
}
