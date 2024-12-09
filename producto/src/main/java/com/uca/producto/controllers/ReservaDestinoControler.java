package com.uca.producto.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uca.producto.entities.ReservaDestino;
import com.uca.producto.logic.LReservaDestino;

@RestController
@RequestMapping("reserva_destino")
@CrossOrigin(origins = "*")
public class ReservaDestinoControler {
    
     @GetMapping({"{id}"})
    public @ResponseBody ReservaDestino Consultar(@PathVariable("id") int id) {
        return new LReservaDestino().Consultar(id);
    }
}
