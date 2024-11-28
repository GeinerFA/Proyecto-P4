package com.uca.producto.controllers;

import com.uca.producto.entities.Cliente;
import com.uca.producto.logic.LCliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    @GetMapping
    public @ResponseBody List<Cliente> Listar() {
        return new LCliente().Listar();
    }

    @GetMapping({"{id}"})
    public @ResponseBody Cliente Consultar(@PathVariable("id") int id) {
        return new LCliente().Consultar(id);
    }

    @PostMapping
    public @ResponseBody int Guardar(@RequestBody Cliente Cliente) {
        return new LCliente().Guardar(Cliente);
    }

    @PutMapping
    public @ResponseBody int Actualizar(@RequestBody Cliente Cliente) {
        return new LCliente().Actualizar(Cliente);
    }
}
