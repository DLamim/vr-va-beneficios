package com.vrvabeneficios.vrvabeneficios.controller;

import com.vrvabeneficios.vrvabeneficios.dto.request.CartaoBeneficiosRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.CartaoBeneficioSaldoResponseDto;
import com.vrvabeneficios.vrvabeneficios.service.cartao.CartaoBeneficiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CartaoBeneficiosController {

    @Autowired
    private CartaoBeneficiosService cartaoBeneficiosService;

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartaoBeneficioSaldoResponseDto> findCartaoById(@PathVariable(value = "id") Long id) {
        Optional<CartaoBeneficioSaldoResponseDto> cartaoBeneficiosDto = cartaoBeneficiosService.findCartaoBeneficiosById(id);

        return cartaoBeneficiosDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCartao(@RequestBody CartaoBeneficiosRequestDto novoCartao) {

        return cartaoBeneficiosService.createCartaoBeneficios(novoCartao);
    }
}
