package com.tindev.apicontato.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tindev.apicontato.dto.ContatoCreateDTO;
import com.tindev.apicontato.dto.ContatoDTO;
import com.tindev.apicontato.entity.ContatoEntity;
import com.tindev.apicontato.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final EmailService emailService;

    private final ObjectMapper objectMapper;

    SimpleDateFormat sdfComplete = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public String save(ContatoCreateDTO contatoCreateDTO) {
        try {
            ContatoDTO contatoDTO = objectMapper.convertValue(contatoCreateDTO, ContatoDTO.class);
            contatoDTO.setData((sdfComplete.format(new Date())));
            emailService.sendEmail(contatoDTO);
            contatoRepository.save(objectMapper.convertValue(contatoDTO, ContatoEntity.class));
            return "Nós recebemos seu contato, em breve entraremos em contato!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContatoDTO> list() {
       return contatoRepository.findAll()
               .stream().
               map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
               .collect(Collectors.toList());
    }


}
