package com.juridico.juridico.servicio.clienteService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juridico.juridico.modelo.Asunto;
import com.juridico.juridico.modelo.Cliente;
import com.juridico.juridico.repositorio.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements ICliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorDni(Long dni) {
        return clienteRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("⚠️ Error: Cliente con DNI " + dni + " no encontrado."));
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        cliente.setFechaCreacion(LocalDateTime.now());
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void eliminarClientePorDni(Long dni) {
        clienteRepository.deleteByDni(dni);
    }

    @Override
    public void eliminarClientePorId(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    @Override
    public Cliente actualizarCliente(Long dni, Cliente cliente) {
        // Validar que el cliente proporcionado no sea nulo

        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }

        Cliente clienteEnSQL = clienteRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("⚠️ Error: Cliente con DNI " + dni + " no encontrado."));

        clienteEnSQL.setNombre(cliente.getNombre());
        clienteEnSQL.setUbicacion(cliente.getUbicacion());
        clienteEnSQL.setTelefono(cliente.getTelefono());

        System.out.println("Cliente modificado por DNI");

        return this.clienteRepository.save(clienteEnSQL);

    }

    // obtenerAsuntosPorDni
    public List<Asunto> obtenerAsuntosPorDni(Long dni) {
        return clienteRepository.findByDni(dni)
                .map(cliente -> {
                    System.out.println("✅ Cliente encontrado: " + cliente.getNombre());
                    return cliente.getAsuntos();
                })
                .orElseThrow(() -> {
                    System.out.println("⚠️ Error: Cliente con DNI " + dni + " no encontrado.");
                    return new RuntimeException("Cliente con DNI " + dni + " no encontrado.");
                });
    }
}
