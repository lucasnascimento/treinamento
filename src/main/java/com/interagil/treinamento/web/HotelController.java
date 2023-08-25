package com.interagil.treinamento.web;


import com.interagil.treinamento.domain.jpa.Hotel;
import com.interagil.treinamento.service.HotelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional()
    @ApiOperation("Adicionando Hotel")
    public Hotel add(@RequestBody Hotel hotel){
        return hotelService.salvar(hotel);
    }

}
