package com.tindev.apicontato.dto;

import com.tindev.apicontato.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {

    private String nome;

    private String email;

    private String assunto;

    @Enumerated(EnumType.STRING)
    private Tipo tipoContato;

    private String mensagem;


}
