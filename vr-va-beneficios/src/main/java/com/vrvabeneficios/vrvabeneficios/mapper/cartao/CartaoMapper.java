package com.vrvabeneficios.vrvabeneficios.mapper.cartao;

import com.vrvabeneficios.vrvabeneficios.dto.request.CartaoBeneficiosRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.CartaoBeneficiosResponseDto;
import com.vrvabeneficios.vrvabeneficios.model.Cartao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartaoMapper {

    public CartaoBeneficiosResponseDto toResponseDto(Cartao cartao) {
        CartaoBeneficiosResponseDto responseDto = new CartaoBeneficiosResponseDto();

        responseDto.setNumeroCartao(cartao.getNumeroCartao());
        responseDto.setSenha(cartao.getSenha());

        return responseDto;
    }

    public Cartao toModel(CartaoBeneficiosRequestDto requestDto) {
        Cartao cartao = new Cartao();

        cartao.setNumeroCartao(requestDto.getNumeroCartao());
        cartao.setSenha(requestDto.getSenha());

        return cartao;
    }

    public List<CartaoBeneficiosResponseDto> listToDto(List<Cartao> cartaoList) {
        List<CartaoBeneficiosResponseDto> dtoList = new ArrayList<>();

        cartaoList.forEach(o -> dtoList.add(toResponseDto(o)));

        return dtoList;
    }
}
