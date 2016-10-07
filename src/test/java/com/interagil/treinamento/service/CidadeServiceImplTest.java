package com.interagil.treinamento.service;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Estados;
import com.interagil.treinamento.validator.CidadeValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CidadeServiceImplTest {

    @Mock
    CidadeValidator cidadeValidator;

    @Mock
    CidadeRepository cidadeRepository;

    @InjectMocks
    CidadeServiceImpl cidadeService;

    @Before
    public void setup(){
        Mockito.reset(cidadeRepository);
    }

    @Test
    public void testeSalvarCidade(){

        Mockito.when(cidadeValidator.validar(Mockito.any(Cidade.class))).thenReturn(true);
        Cidade cidade = new Cidade("Araraquara", Estados.SP);
        cidadeService.salvar(cidade);

        Mockito.verify(cidadeRepository, Mockito.atLeastOnce()).save(Mockito.any(Cidade.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeSalvarCidadeInvalido(){

        Mockito.when(cidadeValidator.validar(Mockito.any(Cidade.class))).thenReturn(false);
        Cidade cidade = new Cidade("x", Estados.SP);
        cidadeService.salvar(cidade);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testSalvarCidadeDuplicada(){
        Mockito.when(cidadeValidator.validar(Mockito.any(Cidade.class))).thenReturn(true);
        Mockito.when(cidadeRepository.countByNomeAndEstado(Mockito.anyString(), Mockito.any(Estados.class))).thenReturn(1);

        Cidade cidade = new Cidade("Araraquara", Estados.SP);
        cidadeService.salvar(cidade);

    }



}