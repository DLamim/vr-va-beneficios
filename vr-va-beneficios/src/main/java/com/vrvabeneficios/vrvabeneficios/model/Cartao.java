package com.vrvabeneficios.vrvabeneficios.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cartao_beneficios")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cartao", nullable = false, length = 16)
    private String numeroCartao;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @Column(name = "senha", nullable = false, length = 6)
    private String senha;

    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
