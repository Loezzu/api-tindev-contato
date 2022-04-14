package com.tindev.apicontato.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tindev.apicontato.dto.contato.ContatoCreateDTO;
import com.tindev.apicontato.dto.contato.ContatoDTO;
import com.tindev.apicontato.entity.ContatoEntity;
import com.tindev.apicontato.enums.TipoLog;
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
    private final LogService logService;
    private final ObjectMapper objectMapper;

    SimpleDateFormat sdfComplete = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public String save(ContatoCreateDTO contatoCreateDTO) {
        try {
            ContatoDTO contatoDTO = objectMapper.convertValue(contatoCreateDTO, ContatoDTO.class);
            contatoDTO.setData((sdfComplete.format(new Date())));
            emailService.sendEmail(contatoDTO);
            ContatoEntity contatoEntity = contatoRepository.save(objectMapper.convertValue(contatoDTO, ContatoEntity.class));
            logService.logPost(TipoLog.CONTACT, "Contact saved with ID: " + contatoEntity.getId());
            return "Nós recebemos seu contato, em breve retornaremos pelo seu email!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContatoDTO> list() throws JsonProcessingException {
        logService.logPost(TipoLog.CONTACT, "All contacts listed");
       return contatoRepository.findAll()
               .stream().
               map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
               .collect(Collectors.toList());
    }


}
