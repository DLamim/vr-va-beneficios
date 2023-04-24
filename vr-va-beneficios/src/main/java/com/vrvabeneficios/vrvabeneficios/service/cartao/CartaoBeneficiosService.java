package com.vrvabeneficios.vrvabeneficios.service.cartao;

import com.vrvabeneficios.vrvabeneficios.dto.request.CartaoBeneficiosRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.CartaoBeneficiosResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CartaoBeneficiosService {

    ResponseEntity<?> createCartaoBeneficios(CartaoBeneficiosRequestDto cartaoBeneficiosRequestDto);

    Optional<CartaoBeneficiosResponseDto> findCartaoBeneficiosById(Long numeroCartao);

    List<CartaoBeneficiosResponseDto> findAllCartaoBeneficios();

    CartaoBeneficiosResponseDto updateCartaoBeneficios(Long id, CartaoBeneficiosRequestDto cartaoBeneficiosRequestDto);

    boolean deleteCartaoBeneficiosById(Long id);
}
