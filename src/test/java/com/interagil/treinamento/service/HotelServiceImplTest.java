package com.interagil.treinamento.service;

import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Estados;
import com.interagil.treinamento.domain.jpa.Hotel;
import com.interagil.treinamento.validator.CidadeValidator;
import com.interagil.treinamento.validator.HotelValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceImplTest {

    @Mock
    HotelValidator hotelValidator;

    @Mock
    HotelRepository hotelRepository;

    @InjectMocks
    HotelServiceImpl hotelService;

    @Before
    public void setup(){
        Mockito.reset(hotelRepository);
    }

    @Test
    public void testeSalvarHotel(){

        Mockito.when(hotelValidator.validar(Mockito.any(Hotel.class))).thenReturn(true);
        Hotel hotel = new Hotel("Ibis - Araraquara", new Cidade("Araraquara", Estados.SP ));
        hotelService.salvar(hotel);

        Mockito.verify(hotelRepository, Mockito.atLeastOnce()).save(Mockito.any(Hotel.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeSalvarHotelInvalido(){

        Mockito.when(hotelValidator.validar(Mockito.any(Hotel.class))).thenReturn(false);
        Hotel hotel = new Hotel("x", new Cidade("Araraquara", Estados.SP ));

        hotelService.salvar(hotel);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSalvarHotelDuplicada(){

        Mockito.when(hotelValidator.validar(Mockito.any(Hotel.class))).thenReturn(true);
        Mockito.when(hotelRepository.countByNome(Mockito.anyString())).thenReturn(1);
        Hotel hotel = new Hotel("Ibis - Araraquara", new Cidade("Araraquara", Estados.SP ));

        hotelService.salvar(hotel);
    }



}