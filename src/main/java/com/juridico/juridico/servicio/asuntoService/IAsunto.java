package com.juridico.juridico.servicio.asuntoService;

import java.util.List;

import com.juridico.juridico.modelo.Asunto;

public interface IAsunto {

    public List<Asunto> listarAsuntos();

    public Asunto crearAsunto(Asunto asunto);

    public Asunto buscarAsuntoPorId(Long id);

    public void eliminarAsuntoPorId(Long id);

    public Asunto actualizarAsunto(Long id,Asunto asunto);

}
