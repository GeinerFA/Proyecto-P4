package com.uca.producto.controllers;

import com.uca.producto.entities.Pais;
import com.uca.producto.logic.LPais;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paises")
@CrossOrigin(origins = "*")
public class PaisController {
    @GetMapping
    public @ResponseBody List<Pais> Listar() {
        return new LPais().Listar();
    }

    @GetMapping({"{id}"})
    public @ResponseBody Pais Consultar(@PathVariable("id") int id) {
        return new LPais().Consultar(id);
    }

    @PostMapping
    public @ResponseBody int Guardar(@RequestBody Pais pais) {
        return new LPais().Guardar(pais);
    }

    @PutMapping
    public @ResponseBody int Actualizar(@RequestBody Pais pais) {
        return new LPais().Actualizar(pais);
    }
}
