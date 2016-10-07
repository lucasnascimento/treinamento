package com.interagil.treinamento.validator;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.mongo.Recomendacao;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by treinamento on 07/10/16.
 */
@Component
public class RecomendacaoValidator {

    /**
     * Validação do objeto cidade
     * @param recomendacao
     */
    public boolean validar(Recomendacao recomendacao) {

        if (StringUtils.isEmpty(recomendacao.getNome())){
            throw new IllegalStateException("Nome é obrigatório.");
        }

        if (StringUtils.isEmpty(recomendacao.getEmail())){
            throw new IllegalStateException("Email é obrigatório.");
        }

        if (recomendacao.getNota() != null
                && (recomendacao.getNota() < 1 || recomendacao.getNota() > 5) ){
            throw new IllegalStateException("Nota deve estar entre 1 e 5");
        }

        if (StringUtils.isEmpty(recomendacao.getRecomendacao())){
            throw new IllegalStateException("Recomendação é obrigatório.");
        }

        return true;
    }

}
