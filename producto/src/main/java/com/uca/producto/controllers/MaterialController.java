package com.uca.producto.controllers;

import com.uca.producto.entities.Material;
import com.uca.producto.logic.LMaterial;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materiales")
@CrossOrigin(origins = "*")
public class MaterialController {
    @GetMapping
    public @ResponseBody List<Material> Listar() {
        return new LMaterial().Listar();
    }

    @PostMapping
    public @ResponseBody int Guardar(@RequestBody Material material) {
        return new LMaterial().Guardar(material);
    }
}
