package com.vrvabeneficios.vrvabeneficios.dto.response;

public class CartaoBeneficiosResponseDto {

    private String senha;
    private String numeroCartao;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
