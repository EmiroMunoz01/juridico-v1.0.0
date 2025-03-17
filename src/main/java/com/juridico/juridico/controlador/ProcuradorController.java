package com.juridico.juridico.controlador;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.juridico.juridico.modelo.Asunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juridico.juridico.modelo.Cliente;
import com.juridico.juridico.modelo.Procurador;
import com.juridico.juridico.servicio.procuradorService.ProcuradorService;

@RestController
@RequestMapping("juridico-app")
@CrossOrigin(value = "http://localhost:4200")

public class ProcuradorController {

    @Autowired
    private ProcuradorService procuradorService;

    @GetMapping("/procuradores/obtener-procuradores")
    public List<Procurador> listarProcuradores() {
        return procuradorService.listarProcuradores();
    }

    @GetMapping("/procuradores/buscar-por-id/{id}")
    public Procurador buscarProcuradorPorId(@PathVariable Long id) {
        return procuradorService.buscarProcuradorPorId(id);
    }

    @GetMapping("/procurador/{procuradorId}/asuntos")
    public Set<Asunto> listarAsuntosPorProcurador(@PathVariable Long procuradorId) {
       return procuradorService.listarAsuntosProcurador(procuradorId);
    }

    @PostMapping("/procuradores/crear-procurador")
    public Procurador crearProcurador(@RequestBody Procurador procurador) {
        return procuradorService.crearProcurador(procurador);
    }

    @DeleteMapping("/procuradores/eliminar-procurador-por-id/{id}")
    public void eliminarProcuradorPorId(@PathVariable Long id) {
        procuradorService.eliminarProcuradorPorId(id);
    }

    // metodo para actualizar un procurador
    @PutMapping("/procuradores/actualizar-procurador/{id}")
    public Procurador actualizarProcurador(@PathVariable Long id,
                                           @RequestBody Procurador procuradorActualizado) {

        return procuradorService.actualizarProcurador(id, procuradorActualizado);
    }

    //metodo para asignar un asunto al procurador
    @PutMapping("/procuradores/{procuradorId}/asignar/{asuntoId}")
    public ResponseEntity<String> asignarProcuradorAAsunto(@PathVariable Long procuradorId,
                                                           @PathVariable Long asuntoId) {
        procuradorService.asignarProcuradorAAsunto(procuradorId, asuntoId);
        return ResponseEntity.ok("Procurador asignado al asunto correctamente");

    }
}
