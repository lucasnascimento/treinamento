package com.interagil.treinamento.web;


import com.interagil.treinamento.domain.jpa.Cidade;
import com.interagil.treinamento.service.CidadeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional()
    @ApiOperation("Adicionando Cidade")
    public Cidade add(@RequestBody Cidade cidade){
        return cidadeService.salvar(cidade);
    }

}
