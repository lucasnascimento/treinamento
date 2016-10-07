package com.interagil.treinamento.validator;

import com.interagil.treinamento.domain.jpa.Cidade;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by treinamento on 06/10/16.
 */
@Component
public class CidadeValidator {

    /**
     * Validação do objeto cidade
     * @param cidade
     */
    public boolean validar(Cidade cidade) {
        if (!StringUtils.isEmpty(cidade.getNome())
                && (cidade.getNome().length() < 3
                || cidade.getNome().length() >= 50) ){
            throw new IllegalStateException("Nome da cidade deve ter entre 3 e 50 caracteres.");
        }

        if(cidade.getEstado() == null){
            throw new IllegalStateException("O Estado é obrigatório.");
        }

        return true;
    }
}
