package com.vrvabeneficios.vrvabeneficios.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponseDto {
    private String numeroCartao;
    private LocalDateTime data;
    private BigDecimal valor;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
