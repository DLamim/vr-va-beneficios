package com.vrvabeneficios.vrvabeneficios.service.cartao.impl;

import com.vrvabeneficios.vrvabeneficios.dto.request.TransacaoRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.TransacaoResponseDto;
import com.vrvabeneficios.vrvabeneficios.exception.InsufficientBalanceException;
import com.vrvabeneficios.vrvabeneficios.exception.InvalidCreditCardNumberException;
import com.vrvabeneficios.vrvabeneficios.exception.InvalidPasswordException;
import com.vrvabeneficios.vrvabeneficios.exception.ResourceNotFoundException;
import com.vrvabeneficios.vrvabeneficios.model.Cartao;
import com.vrvabeneficios.vrvabeneficios.repository.cartao.CartaoBeneficiosRepository;
import com.vrvabeneficios.vrvabeneficios.service.cartao.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    CartaoBeneficiosRepository cartaoBeneficiosRepository;

    @Override
    public TransacaoResponseDto realizaTransacao(TransacaoRequestDto transacaoRequestDto) {
        //Obter cartão para transação
        Cartao cartao = obtemCartao(transacaoRequestDto.getNumeroCartao());

        //Verifica senha e saldo
        validaSenha(transacaoRequestDto, cartao);
        verificaSaldo(transacaoRequestDto, cartao);

        TransacaoResponseDto transacaoResponseDto = new TransacaoResponseDto();

        atualizaSaldo(cartao, transacaoRequestDto.getValor());

        transacaoResponseDto.setNumeroCartao(transacaoRequestDto.getNumeroCartao());
        transacaoResponseDto.setValor(transacaoRequestDto.getValor());
        transacaoResponseDto.setData(LocalDateTime.now());

        return transacaoResponseDto;
    }

    @Override
    public Boolean verificaSaldo(TransacaoRequestDto transacaoRequestDto, Cartao cartao) {

        BigDecimal saldoAtual = cartao.getSaldo();
        Boolean temSaldo = saldoAtual.compareTo(transacaoRequestDto.getValor()) >= 0;

        return Stream.of(temSaldo)
                .filter(Boolean::booleanValue)
                .findFirst()
                .orElseThrow(() -> new InsufficientBalanceException("SALDO_INSUFICIENTE"));
    }

    @Override
    public void validaSenha(TransacaoRequestDto transacaoRequestDto, Cartao cartao) {

        cartaoBeneficiosRepository.findByNumeroCartaoAndSenha(transacaoRequestDto.getNumeroCartao(), transacaoRequestDto.getSenha())
                .orElseThrow(() -> new InvalidPasswordException("SENHA_INVALIDA"));
    }

    @Override
    public Cartao obtemCartao(String numeroCartao) {

        return cartaoBeneficiosRepository.findByNumeroCartao(numeroCartao)
                .orElseThrow(() -> new InvalidCreditCardNumberException("CARTAO_INEXISTENTE"));
    }

    @Override
    public void atualizaSaldo(Cartao cartao, BigDecimal valor) {
        BigDecimal novoSaldo = cartao.getSaldo().subtract(valor);
        cartao.setSaldo(novoSaldo);
        cartaoBeneficiosRepository.save(cartao);
    }


}
