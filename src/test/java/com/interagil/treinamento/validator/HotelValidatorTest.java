package com.interagil.treinamento.validator;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Estados;
import com.interagil.treinamento.domain.jpa.Hotel;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by treinamento on 06/10/16.
 */
public class HotelValidatorTest {

    @Test(expected = IllegalStateException.class)
    public void testeHotelNomePequeno(){
        Hotel hotel = new Hotel("x", new Cidade ("Araraquara", Estados.SP));
        new HotelValidator().validar(hotel);
    }

    @Test(expected = IllegalStateException.class)
    public void testeHotelNomeGrande(){
        Hotel hotel = new Hotel("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", new Cidade ("Araraquara", Estados.SP));
        new HotelValidator().validar(hotel);
    }

    @Test(expected = IllegalStateException.class)
    public void testeHotelCidadeVazia(){
        Hotel hotel = new Hotel("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", null);
        new HotelValidator().validar(hotel);
    }

    @Test()
    public void testeNomeCidadeValido(){
        Hotel hotel = new Hotel("Ibis - Araraquara", new Cidade ("Araraquara", Estados.SP));
        boolean ehValido = new HotelValidator().validar(hotel);
        Assert.assertTrue(ehValido);
    }

}