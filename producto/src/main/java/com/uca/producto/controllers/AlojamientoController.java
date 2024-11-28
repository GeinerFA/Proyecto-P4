package com.uca.producto.controllers;

import com.uca.producto.entities.Alojamiento;
import com.uca.producto.logic.LAlojamiento;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alojamientos")
@CrossOrigin(origins = "*")
public class AlojamientoController {
    @GetMapping
    public @ResponseBody List<Alojamiento> Listar() {
        return new LAlojamiento().Listar();
    }

    @GetMapping({"{id}"})
    public @ResponseBody Alojamiento Consultar(@PathVariable("id") int id) {
        return new LAlojamiento().Consultar(id);
    }

    @PostMapping
    public @ResponseBody int Guardar(@RequestBody Alojamiento Alojamiento) {
        return new LAlojamiento().Guardar(Alojamiento);
    }

    @PutMapping
    public @ResponseBody int Actualizar(@RequestBody Alojamiento Alojamiento) {
        return new LAlojamiento().Actualizar(Alojamiento);
    }
}
