package com.interagil.treinamento.validator;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Estados;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by treinamento on 06/10/16.
 */
public class CidadeValidatorTest {

    @Test(expected = IllegalStateException.class)
    public void testeNomePequeno(){
        Cidade cidade = new Cidade("x", Estados.SP);
        new CidadeValidator().validar(cidade);
    }

    @Test(expected = IllegalStateException.class)
    public void testeNomeGrande(){
        Cidade cidade = new Cidade("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", Estados.SP);
        new CidadeValidator().validar(cidade);
    }

    @Test(expected = IllegalStateException.class)
    public void testeEstadoVazio(){
        Cidade cidade = new Cidade("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", null);
        new CidadeValidator().validar(cidade);
    }

    @Test()
    public void testeNomeCidadeValido(){
        Cidade cidade = new Cidade("Araraquara", Estados.SP);
        boolean ehValido = new CidadeValidator().validar(cidade);
        Assert.assertTrue(ehValido);
    }

}