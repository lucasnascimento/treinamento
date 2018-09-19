package com.interagil.treinamento.validator;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Hotel;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by treinamento on 06/10/16.
 */
@Component
public class HotelValidator {

    /**
     * Validação do objeto hotel
     * @param hotel
     */
    public boolean validar(Hotel hotel) {
        if (!StringUtils.isEmpty(hotel.getNome())
                && (hotel.getNome().length() < 3
                || hotel.getNome().length() >= 50) ){
            throw new IllegalStateException("Nome do Hotel deve ter entre 3 e 50 caracteres.");
        }

        if(hotel.getCidade() == null){
            throw new IllegalStateException("A cidade é obrigatório.");
        }

        return true;
    }
}
