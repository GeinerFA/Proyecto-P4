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

import com.uca.producto.entities.Tour;
import com.uca.producto.logic.LTour;

@RestController
@RequestMapping("tours")
@CrossOrigin(origins = "*")
public class TourController {
    @GetMapping
    public @ResponseBody List<Tour> Listar() {
        return new LTour().Listar();
    }
 
    @GetMapping({"{id}"})
    public @ResponseBody Tour Consultar(@PathVariable("id") int id) {
        return new LTour().Consultar(id);
    }
 
    @PostMapping
    public @ResponseBody int Guardar(@RequestBody Tour Tour) {
        return new LTour().Guardar(Tour);
    }
 
    @PutMapping
    public @ResponseBody int Actualizar(@RequestBody Tour Tour) {
        return new LTour().Actualizar(Tour);
    }
}
