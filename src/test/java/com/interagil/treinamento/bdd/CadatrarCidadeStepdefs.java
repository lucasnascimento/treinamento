package com.interagil.treinamento.bdd;

import com.interagil.treinamento.Application;
import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.domain.jpa.Estados;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest
public class CadatrarCidadeStepdefs {

    private  Cidade cidade;

    @Quando("^o usuario for cadastrar a cidade \"([^\"]*)\" no estado de \"([^\"]*)\"$")
    public void oUsuarioForCadastrarACidadeNoEstadoDe(String nome_cidade, String nome_estado) throws Throwable {
        cidade = new Cidade(nome_cidade, !StringUtils.isEmpty(nome_estado) ? Estados.valueOf(nome_estado) : null);
    }

    @Então("^deve ser retornado \"([^\"]*)\"$")
    public void deveSerRetornado(Integer codigo_retorno) throws Throwable {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Cidade> exchange = restTemplate.exchange("http://localhost:2808/cidade/", HttpMethod.PUT, new HttpEntity<Cidade>(cidade), Cidade.class);
            Assert.assertEquals(exchange.getStatusCode().value(), codigo_retorno.intValue());
        }catch (HttpServerErrorException e){
            Assert.assertEquals(e.getStatusCode().value(), codigo_retorno.intValue());
        }
    }
}
