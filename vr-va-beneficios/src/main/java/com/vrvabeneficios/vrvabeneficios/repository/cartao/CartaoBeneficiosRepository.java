package com.vrvabeneficios.vrvabeneficios.repository.cartao;

import com.vrvabeneficios.vrvabeneficios.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoBeneficiosRepository extends JpaRepository<Cartao, Long> {
    Optional<Cartao> findByNumeroCartao(String numeroCartao);

    Optional<Cartao> findByNumeroCartaoAndSenha(String numeroCartao, String senha);
}
