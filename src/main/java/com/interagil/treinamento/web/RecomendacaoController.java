package com.interagil.treinamento.web;


import com.interagil.treinamento.domain.jpa.Hotel;
import com.interagil.treinamento.domain.mongo.Recomendacao;
import com.interagil.treinamento.service.HotelService;
import com.interagil.treinamento.service.RecomendacaoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/recomendacao")
public class RecomendacaoController {

    @Autowired
    private RecomendacaoService recomendacaoService;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional()
    @ApiOperation("Adicionando Recomendacao")
    public Recomendacao add(@RequestBody Recomendacao recomendacao){
        return recomendacaoService.salvar(recomendacao);
    }

}
