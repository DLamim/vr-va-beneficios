package com.vrvabeneficios.vrvabeneficios.dto.request;

public class CartaoBeneficiosRequestDto {

    private String numeroCartao;
    private String senha;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
