package com.vrvabeneficios.vrvabeneficios.controller;

import com.vrvabeneficios.vrvabeneficios.dto.request.TransacaoRequestDto;
import com.vrvabeneficios.vrvabeneficios.dto.response.TransacaoResponseDto;
import com.vrvabeneficios.vrvabeneficios.service.cartao.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class AutorizadorController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransacaoResponseDto> createTransacao(@RequestBody TransacaoRequestDto transacaoRequestDto) {
        TransacaoResponseDto transacaoResponseDto = transacaoService.realizaTransacao(transacaoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoResponseDto);
    }
}
