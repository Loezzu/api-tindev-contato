package com.tindev.apicontato.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tindev.apicontato.dto.log.LogDTO;
import com.tindev.apicontato.enums.TipoLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final ProducerService producerService;

    public void logPost(TipoLog tipoLog, String mensagem) throws JsonProcessingException {
        LogDTO log = LogDTO.builder()
                .tipoLog(tipoLog)
                .descricao(mensagem).build();
        producerService.sendLog(log);
    }
}
