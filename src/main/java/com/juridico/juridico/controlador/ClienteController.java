package com.juridico.juridico.controlador;

import java.time.LocalDateTime;
import java.util.List;

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

import com.juridico.juridico.modelo.Asunto;
import com.juridico.juridico.modelo.Cliente;
import com.juridico.juridico.servicio.clienteService.ClienteService;

@RestController
@RequestMapping("juridico-app")
@CrossOrigin(value = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // metodo para listar todos los clientes
    @GetMapping("/clientes/obtener-clientes")
    public List<Cliente> listarEntrenadores() {
        return clienteService.listarClientes();
    }

    // metodo para filtrar un cliente por id
    @GetMapping("/clientes/buscar-por-id/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    // metodo para filtrar un cliente por dni
    @GetMapping("/clientes/buscar-por-dni/{dniCliente}")
    public Cliente buscarClientePorDni(@PathVariable Long dniCliente) {
        return clienteService.buscarClientePorDni(dniCliente);
    }

    // metodo para crear un cliente
    @PostMapping("/clientes/crear-cliente")
    public Cliente crearCliente(@RequestBody Cliente cliente) {

        return clienteService.crearCliente(cliente);

    }

    // metodo para eliminar un cliente por dni
    @DeleteMapping("/clientes/eliminar-cliente-por-dni/{dni}")
    public void eliminarClientePorDNI(@PathVariable Long dni) {
        clienteService.eliminarClientePorDni(dni);
    }

    @DeleteMapping("/clientes/eliminar-cliente-por-id/{id}")
    public void eliminarClientePorID(@PathVariable Long id) {
        clienteService.eliminarClientePorId(id);
    }

    // metodo para actualizar un cliente por dni
    @PutMapping("/clientes/actualizar-cliente/{dni}")
    public Cliente actualizarCliente(@PathVariable Long dni,
            @RequestBody Cliente clienteActualizado) {

        return clienteService.actualizarCliente(dni, clienteActualizado);
    }

    @GetMapping("/clientes/{dni}/asuntos")
    public ResponseEntity<List<Asunto>> obtenerAsuntos(@PathVariable Long dni) {
        List<Asunto> asuntos = clienteService.obtenerAsuntosPorDni(dni);
        return ResponseEntity.ok(asuntos);
    }

    
}
