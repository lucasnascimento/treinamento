package com.interagil.treinamento.service;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Estados;
import com.interagil.treinamento.domain.jpa.Hotel;
import com.interagil.treinamento.domain.mongo.Recomendacao;
import com.interagil.treinamento.validator.HotelValidator;
import com.interagil.treinamento.validator.RecomendacaoValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RecomendacaoServiceImplTest {

    @Mock
    RecomendacaoValidator recomendacaoValidator;

    @Mock
    RecomendacaoRepository recomendacaoRepository;

    @InjectMocks
    RecomendacaoServiceImpl recomendacaoService;

    @Before
    public void setup(){
        Mockito.reset(recomendacaoRepository);
    }

    @Test
    public void testeSalvarRecomendacao(){

        Mockito.when(recomendacaoValidator.validar(Mockito.any(Recomendacao.class))).thenReturn(true);
        Recomendacao recomendacao = new Recomendacao("Usuário", "email", 1, "recomendacao", 1);
        recomendacaoService.salvar(recomendacao);

        Mockito.verify(recomendacaoRepository, Mockito.atLeastOnce()).save(Mockito.any(Recomendacao.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeSalvarRecomendacaoInvalido(){

        Mockito.when(recomendacaoValidator.validar(Mockito.any(Recomendacao.class))).thenReturn(false);
        Recomendacao recomendacao = new Recomendacao("Usuário", "email", 1, "recomendacao", 1);
        recomendacaoService.salvar(recomendacao);

    }

}