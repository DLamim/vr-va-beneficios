package com.vrvabeneficios.vrvabeneficios.service.cartao;

import com.vrvabeneficios.vrvabeneficios.dto.request.TransacaoRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.TransacaoResponseDto;
import com.vrvabeneficios.vrvabeneficios.model.Cartao;

import java.math.BigDecimal;

public interface TransacaoService {

    TransacaoResponseDto realizaTransacao(TransacaoRequestDto transacaoRequestDto);

    Boolean verificaSaldo(TransacaoRequestDto transacaoRequestDto, Cartao cartao);

    void validaSenha(TransacaoRequestDto transacaoRequestDto, Cartao cartao);

    Cartao obtemCartao(String numeroCartao);

    void atualizaSaldo(Cartao cartao, BigDecimal valor);
}
