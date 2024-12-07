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

import com.uca.producto.entities.Reserva;
import com.uca.producto.logic.LReserva;

@RestController
@RequestMapping("reservas")
@CrossOrigin(origins = "*")
public class ReservaController {
    @GetMapping
    public @ResponseBody List<Reserva> Listar() {
        return new LReserva().Listar();
    }

    @GetMapping({"{id}"})
    public @ResponseBody Reserva Consultar(@PathVariable("id") int id) {
        return new LReserva().Consultar(id);
    }

    @PostMapping
    public @ResponseBody int Guardar(@RequestBody Reserva Reserva) {
        return new LReserva().Guardar(Reserva);
    }

    @PutMapping
    public @ResponseBody int Actualizar(@RequestBody Reserva Reserva) {
        return new LReserva().Actualizar(Reserva);
    }
}
