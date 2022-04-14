package com.tindev.apicontato.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tindev.apicontato.dto.contato.ContatoCreateDTO;
import com.tindev.apicontato.dto.contato.ContatoDTO;
import com.tindev.apicontato.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @PostMapping("/salvar")
    public String saveContato(@RequestBody ContatoCreateDTO contatoCreateDTO) {
        return contatoService.save(contatoCreateDTO);
    }

    @GetMapping("/listar")
    public List<ContatoDTO> listContato() throws JsonProcessingException {
        return contatoService.list();
    }
}
