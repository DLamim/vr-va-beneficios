package com.vrvabeneficios.vrvabeneficios.dto.request;

import java.math.BigDecimal;

public class TransacaoRequestDto {
    private String numeroCartao;
    private String senha;
    private BigDecimal valor;

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
