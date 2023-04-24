package com.vrvabeneficios.vrvabeneficios.controller;

import com.vrvabeneficios.vrvabeneficios.dto.request.CartaoBeneficiosRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.CartaoBeneficiosResponseDto;
import com.vrvabeneficios.vrvabeneficios.service.cartao.CartaoBeneficiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CartaoBeneficiosController {

    @Autowired
    private CartaoBeneficiosService cartaoBeneficiosService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CartaoBeneficiosResponseDto>> findAllCartao() {
        List<CartaoBeneficiosResponseDto> cartaosDto = cartaoBeneficiosService.findAllCartaoBeneficios();

        return ResponseEntity.ok(cartaosDto);
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartaoBeneficiosResponseDto> findCartaoById(@PathVariable(value = "id") Long id) {
        Optional<CartaoBeneficiosResponseDto> cartaoBeneficiosDto = cartaoBeneficiosService.findCartaoBeneficiosById(id);

        return cartaoBeneficiosDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCartao(@RequestBody CartaoBeneficiosRequestDto novoCartao) {

        return cartaoBeneficiosService.createCartaoBeneficios(novoCartao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartaoBeneficiosResponseDto> updateCartao(@PathVariable Long id, @RequestBody CartaoBeneficiosRequestDto cartaoBeneficiosRequestDto) {
        CartaoBeneficiosResponseDto cartaoAtualizado = cartaoBeneficiosService.updateCartaoBeneficios(id, cartaoBeneficiosRequestDto);
        return new ResponseEntity<>(cartaoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartao(@PathVariable Long id) {
        boolean deleted = cartaoBeneficiosService.deleteCartaoBeneficiosById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
