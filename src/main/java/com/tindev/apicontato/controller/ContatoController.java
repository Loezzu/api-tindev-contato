package com.tindev.apicontato.controller;

import com.tindev.apicontato.dto.ContatoCreateDTO;
import com.tindev.apicontato.dto.ContatoDTO;
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
    public List<ContatoDTO> listContato() {
        return contatoService.list();
    }
}
