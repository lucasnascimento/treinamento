package com.interagil.treinamento.validator;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Estados;
import com.interagil.treinamento.domain.mongo.Recomendacao;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by treinamento on 06/10/16.
 */
public class RecomendacaoValidatorTest {

    @Test(expected = IllegalStateException.class)
    public void testeNomeNaoInformado(){
        Recomendacao recomendacao = new Recomendacao();
        new RecomendacaoValidator().validar(recomendacao);
    }

    @Test(expected = IllegalStateException.class)
    public void testeEmailNaoInformado(){
        Recomendacao recomendacao = new Recomendacao();
        recomendacao.setNome("x");
        new RecomendacaoValidator().validar(recomendacao);
    }

    @Test(expected = IllegalStateException.class)
    public void testeNotaVazia(){
        Recomendacao recomendacao = new Recomendacao();
        recomendacao.setNome("x");
        recomendacao.setEmail("x");
        new RecomendacaoValidator().validar(recomendacao);
    }

    @Test(expected = IllegalStateException.class)
    public void testeNotaZero(){
        Recomendacao recomendacao = new Recomendacao();
        recomendacao.setNome("x");
        recomendacao.setEmail("x");
        recomendacao.setNota(0);
        new RecomendacaoValidator().validar(recomendacao);
    }

    @Test(expected = IllegalStateException.class)
    public void testeNotaNegativa(){
        Recomendacao recomendacao = new Recomendacao();
        recomendacao.setNome("x");
        recomendacao.setEmail("x");
        recomendacao.setNota(-1);
        new RecomendacaoValidator().validar(recomendacao);
    }

    @Test(expected = IllegalStateException.class)
    public void testeNotaMaiorQueCinco(){
        Recomendacao recomendacao = new Recomendacao();
        recomendacao.setNome("x");
        recomendacao.setEmail("x");
        recomendacao.setNota(6);
        new RecomendacaoValidator().validar(recomendacao);
    }

    @Test(expected = IllegalStateException.class)
    public void testeNotaBemMaiorQueCinco(){
        Recomendacao recomendacao = new Recomendacao();
        recomendacao.setNome("x");
        recomendacao.setEmail("x");
        recomendacao.setNota(99999);
        new RecomendacaoValidator().validar(recomendacao);
    }

}