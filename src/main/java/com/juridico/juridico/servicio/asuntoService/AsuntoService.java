package com.juridico.juridico.servicio.asuntoService;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juridico.juridico.modelo.Asunto;
import com.juridico.juridico.repositorio.AsuntoRepository;

import jakarta.transaction.Transactional;

@Service
public class AsuntoService implements IAsunto {

    @Autowired
    private AsuntoRepository asuntoRepository;

    @Override
    public Asunto crearAsunto(Asunto asunto) {
        asunto.setFechaCreacion(LocalDateTime.now());
        return asuntoRepository.save(asunto);
    }

    @Override
    public List<Asunto> listarAsuntos() {
        return (List<Asunto>) asuntoRepository.findAll();
    }

    @Override
    public Asunto buscarAsuntoPorId(Long idAsunto) {
        return asuntoRepository.findById(idAsunto).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarAsuntoPorId(Long idAsunto) {
        asuntoRepository.deleteById(idAsunto);
    }

    @Override
    public Asunto actualizarAsunto(Long id, Asunto asunto) {

        Asunto asuntoEnSQL = asuntoRepository.findById(id).orElse(null);
        asuntoEnSQL.setDescripcion(asunto.getDescripcion());

        return asuntoRepository.save(asunto);
    }

}
