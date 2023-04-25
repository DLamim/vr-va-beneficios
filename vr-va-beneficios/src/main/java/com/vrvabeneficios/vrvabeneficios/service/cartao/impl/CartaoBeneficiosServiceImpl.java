package com.vrvabeneficios.vrvabeneficios.service.cartao.impl;

import com.vrvabeneficios.vrvabeneficios.dto.request.CartaoBeneficiosRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.CartaoBeneficioSaldoResponseDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.CartaoBeneficiosResponseDto;
import com.vrvabeneficios.vrvabeneficios.exception.ResourceNotFoundException;
import com.vrvabeneficios.vrvabeneficios.mapper.cartao.CartaoMapper;
import com.vrvabeneficios.vrvabeneficios.model.Cartao;
import com.vrvabeneficios.vrvabeneficios.repository.cartao.CartaoBeneficiosRepository;
import com.vrvabeneficios.vrvabeneficios.service.cartao.CartaoBeneficiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CartaoBeneficiosServiceImpl implements CartaoBeneficiosService {

    @Autowired
    CartaoBeneficiosRepository cartaoBeneficiosRepository;

    @Autowired
    CartaoMapper cartaoMapper;

    @Override
    public ResponseEntity<?> createCartaoBeneficios(CartaoBeneficiosRequestDto cartaoBeneficiosRequestDto) {
        Optional<Cartao> cartaoOptional = cartaoBeneficiosRepository.findByNumeroCartao(cartaoBeneficiosRequestDto.getNumeroCartao());

        if (cartaoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().body(cartaoBeneficiosRequestDto);
        }

        Cartao cartao = cartaoMapper.toModel(cartaoBeneficiosRequestDto);
        cartao.setSaldo(new BigDecimal(500));
        CartaoBeneficiosResponseDto responseDto = cartaoMapper.toResponseDto(cartaoBeneficiosRepository.save(cartao));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @Override
    public Optional<CartaoBeneficioSaldoResponseDto> findCartaoBeneficiosById(Long numeroCartao) {

        Cartao entity = cartaoBeneficiosRepository.findById(numeroCartao)
                .orElseThrow(ResourceNotFoundException::new);

        CartaoBeneficioSaldoResponseDto saldoResponseDto = new CartaoBeneficioSaldoResponseDto();

        saldoResponseDto.setSaldo(entity.getSaldo());
        return Optional.of(saldoResponseDto);
    }
}
