package com.interagil.treinamento.bdd;

import com.interagil.treinamento.Application;
import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Estados;
import com.interagil.treinamento.domain.jpa.Hotel;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest
public class CadatrarHotelStepdefs {


    private Hotel hotel;
    private static Cidade cidade;

    RestTemplate restTemplate = new RestTemplate();

    @Dado("^que esteja cadastrado no sistema a cidade de \"([^\"]*)\" estado de \"([^\"]*)\"$")
    public void queEstejaCadastradoNoSistemaACidadeDeEstadoDe(String nome_cidade, String nome_estado) throws Throwable {
        if (cidade == null){
            Cidade novaCidade = new Cidade(nome_cidade, !StringUtils.isEmpty(nome_estado) ? Estados.valueOf(nome_estado) : null);
            ResponseEntity<Cidade> exchange = restTemplate.exchange("http://localhost:2808/cidade/", HttpMethod.PUT, new HttpEntity<Cidade>(novaCidade), Cidade.class);
            Assert.assertEquals(HttpStatus.OK, exchange.getStatusCode());
            cidade = exchange.getBody();
        }
    }

    @Quando("^o usuario for cadastrar o hotel \"([^\"]*)\" no cidade de \"([^\"]*)\"$")
    public void oUsuarioForCadastrarACidadeNoEstadoDe(String nome_hotel, String nome_cidade) throws Throwable {
        hotel = new Hotel(nome_hotel, !StringUtils.isEmpty(nome_cidade) ? cidade : null);
    }

    @Então("^para o hotel deve ser retornado \"([^\"]*)\"$")
    public void deveSerRetornado(Integer codigo_retorno) throws Throwable {
        try {
            ResponseEntity<Hotel> exchange = restTemplate.exchange("http://localhost:2808/hotel/", HttpMethod.PUT, new HttpEntity<Hotel>(hotel), Hotel.class);
            Assert.assertEquals(exchange.getStatusCode().value(), codigo_retorno.intValue());
        }catch (HttpServerErrorException e){
            Assert.assertEquals(e.getStatusCode().value(), codigo_retorno.intValue());
        }
    }

}
