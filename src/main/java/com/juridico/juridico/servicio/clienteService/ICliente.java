package com.juridico.juridico.servicio.clienteService;

import java.util.List;

import com.juridico.juridico.modelo.Cliente;

public interface ICliente {

    public List<Cliente> listarClientes();

    public Cliente buscarClientePorDni(Long dniCliente);

    public Cliente buscarClientePorId(Long id);

    public Cliente crearCliente(Cliente cliente);

    public void eliminarClientePorDni(Long dniCliente);

    public void eliminarClientePorId(Long idCliente);

    public Cliente actualizarCliente(Long id,Cliente cliente);

}
