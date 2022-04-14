package com.tindev.apicontato.repository;

import com.tindev.apicontato.entity.ContatoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContatoRepository extends MongoRepository<ContatoEntity, String> {
}
