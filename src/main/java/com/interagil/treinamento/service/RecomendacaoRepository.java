
package com.interagil.treinamento.service;

import com.interagil.treinamento.domain.mongo.Person;
import com.interagil.treinamento.domain.mongo.Recomendacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface RecomendacaoRepository extends MongoRepository<Recomendacao, String> {

}
