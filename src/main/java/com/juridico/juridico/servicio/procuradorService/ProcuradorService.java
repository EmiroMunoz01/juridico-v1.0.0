package com.juridico.juridico.servicio.procuradorService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.juridico.juridico.modelo.Asunto;
import com.juridico.juridico.modelo.Procurador;
import com.juridico.juridico.repositorio.AsuntoRepository;
import com.juridico.juridico.repositorio.ProcuradorRepository;

@Service
public class ProcuradorService implements IProcurador {

    @Autowired
    private ProcuradorRepository procuradorRepository;

    @Autowired
    private AsuntoRepository asuntoRepository;

    @Override
    public List<Procurador> listarProcuradores() {
        return (List<Procurador>) procuradorRepository.findAll();
    }


    public Set<Asunto> listarAsuntosProcurador(Long idProcurador) {
        Procurador procurador = procuradorRepository.findById(idProcurador).orElseThrow(() -> new RuntimeException("Procurador no encontrado"));
        return procurador.getAsuntos();
    }


    @Override
    public Procurador buscarProcuradorPorId(Long idProcurador) {
        return procuradorRepository.findById(idProcurador).orElse(null);
    }

    @Override
    public Procurador crearProcurador(Procurador procurador) {
        procurador.setFechaCreacion(LocalDateTime.now());
        return procuradorRepository.save(procurador);
    }

    @Override
    public void eliminarProcuradorPorId(Long idProcurador) {
        procuradorRepository.deleteById(idProcurador);
    }

    @Override
    public Procurador actualizarProcurador(Long id, Procurador procurador) {

        Procurador procuradorEnSQL = procuradorRepository.findById(id).orElse(null);

        procuradorEnSQL.setNombre(procurador.getNombre());
        procuradorEnSQL.setTelefono(procurador.getTelefono());
        procuradorEnSQL.setAsuntos(procurador.getAsuntos());

        return this.procuradorRepository.save(procurador);
    }

    public void asignarProcuradorAAsunto(Long procuradorId, Long asuntoId) {
        // 1. Buscar el Procurador
        Procurador procurador = procuradorRepository.findById(procuradorId)
                .orElseThrow(() -> new RuntimeException("Procurador no encontrado"));

        // 2. Buscar el Asunto
        Asunto asunto = asuntoRepository.findById(asuntoId)
                .orElseThrow(() -> new RuntimeException("Asunto no encontrado"));

        // 3. Agregar la relación
        procurador.getAsuntos().add(asunto);
        asunto.getProcuradores().add(procurador);

        // 4. Guardar los cambios
        procuradorRepository.save(procurador);
        asuntoRepository.save(asunto);
    }

    public void cambiarEstadoDelAsunto(Long procuradorId, Long asuntoId, String estado) {

    }


}
