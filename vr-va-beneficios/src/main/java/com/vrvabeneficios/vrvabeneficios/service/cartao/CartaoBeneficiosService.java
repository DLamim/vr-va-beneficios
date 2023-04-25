package com.vrvabeneficios.vrvabeneficios.service.cartao;

import com.vrvabeneficios.vrvabeneficios.dto.request.CartaoBeneficiosRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.CartaoBeneficioSaldoResponseDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.CartaoBeneficiosResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CartaoBeneficiosService {

    ResponseEntity<?> createCartaoBeneficios(CartaoBeneficiosRequestDto cartaoBeneficiosRequestDto);

    Optional<CartaoBeneficioSaldoResponseDto> findCartaoBeneficiosById(Long numeroCartao);

}
