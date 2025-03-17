package com.juridico.juridico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juridico.juridico.modelo.Asunto;
import com.juridico.juridico.servicio.asuntoService.AsuntoService;

@RestController
@RequestMapping("juridico-app")
@CrossOrigin(value = "http://localhost:4200")
public class AsuntoController {

    @Autowired
    private AsuntoService asuntoService;

    // metodo para listar todos los asuntos existentes
    @GetMapping("/asuntos/obtener-asuntos")
    public List<Asunto> listarAsuntos() {
        return asuntoService.listarAsuntos();
    }

    // metodo para listar un asunto por id
    @GetMapping("/asuntos/buscar-por-id/{id}")
    public Asunto buscarAsuntoPorId(@PathVariable Long id) {
        return asuntoService.buscarAsuntoPorId(id);
    }

    @PostMapping("/asuntos/crear-asunto")
    public Asunto crearAsunto(@RequestBody Asunto asunto) {
        return asuntoService.crearAsunto(asunto);
    }

    @PutMapping("/asuntos/actualizar-asunto/{id}")
    public Asunto actualizarAsunto(@PathVariable Long id, @RequestBody Asunto asuntoBase) {

        return asuntoService.actualizarAsunto(id, asuntoBase);

    }
}
