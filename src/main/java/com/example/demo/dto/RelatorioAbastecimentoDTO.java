package com.example.demo.DTO;

public class RelatorioAbastecimentoDTO {
    private String dia;
    private String tanque;
    private String bomba;
    private String combustivel;
    private double valor;

    public RelatorioAbastecimentoDTO() {
    }

    public RelatorioAbastecimentoDTO(String dia, String tanque, String bomba, String combustivel, double valor) {
        this.dia = dia;
        this.tanque = tanque;
        this.bomba = bomba;
        this.combustivel = combustivel;
        this.valor = valor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTanque() {
        return tanque;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }

    public String getBomba() {
        return bomba;
    }

    public void setBomba(String bomba) {
        this.bomba = bomba;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
