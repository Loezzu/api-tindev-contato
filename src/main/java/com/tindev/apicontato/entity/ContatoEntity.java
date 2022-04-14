package com.tindev.apicontato.entity;


import com.tindev.apicontato.enums.Tipo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Document(collection = "contato_tindev")
@Getter
@Setter
public class ContatoEntity {

    @Id
    private String id;

    private String nome;

    private String email;

    private String assunto;

    @Enumerated(EnumType.STRING)
    private Tipo tipoContato;

    private String mensagem;

    private String data;



}
