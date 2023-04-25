package com.vrvabeneficios.vrvabeneficios.dto.response;

import java.math.BigDecimal;

public class CartaoBeneficioSaldoResponseDto {

    private BigDecimal saldo;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
