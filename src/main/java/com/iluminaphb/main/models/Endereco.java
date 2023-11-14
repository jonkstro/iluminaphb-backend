package com.iluminaphb.main.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

// Quer dizer que não vai salvar no BD uma entidade endereço, por isso @Embeddable
@Embeddable
public class Endereco implements Serializable {
    @NotNull(message = "Número é obrigatório")
    private Integer numero;
    @NotNull(message = "Rua é obrigatória")
    private String rua;
    @NotNull(message = "Bairro é obrigatório")
    private String bairro;
    private String pontoReferencia;
    private Double latitude;
    private Double longitude;

    public Endereco() {
    }

    public Endereco(
            Integer numero,
            String rua,
            String bairro,
            String pontoReferencia,
            Double latitude,
            Double longitude) {
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
