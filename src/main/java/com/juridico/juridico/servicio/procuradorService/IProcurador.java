package com.juridico.juridico.servicio.procuradorService;

import java.util.List;

import com.juridico.juridico.modelo.Procurador;

public interface IProcurador {

    public List<Procurador> listarProcuradores();

    public Procurador buscarProcuradorPorId(Long id);

    public Procurador crearProcurador(Procurador procurador);

    public void eliminarProcuradorPorId(Long idProcurador);

    public Procurador actualizarProcurador(Long id, Procurador procurador);

}
