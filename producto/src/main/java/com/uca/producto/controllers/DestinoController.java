package com.uca.producto.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uca.producto.entities.Destino;
import com.uca.producto.logic.LDestino;

@RestController
@RequestMapping("destinos")
@CrossOrigin(origins = "*")
public class DestinoController {
    @GetMapping
    public @ResponseBody List<Destino> Listar() {
        return new LDestino().Listar();
    }

    @GetMapping({"{id}"})
    public @ResponseBody Destino Consultar(@PathVariable("id") int id) {
        return new LDestino().Consultar(id);
    }

    @PostMapping
    public @ResponseBody int Guardar(@RequestBody Destino Destino) {
        return new LDestino().Guardar(Destino);
    }

    @PutMapping
    public @ResponseBody int Actualizar(@RequestBody Destino Destino) {
        return new LDestino().Actualizar(Destino);
    }
}
