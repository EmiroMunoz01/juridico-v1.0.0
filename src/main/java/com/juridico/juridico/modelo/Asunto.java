package com.juridico.juridico.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "asunto")
public class Asunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_asunto")
    private EstadoAsunto estado;

    @ManyToOne
    @JoinColumn(name = "cliente_dni", nullable = false)
    @JsonBackReference("cliente-asuntos")
    private Cliente cliente;

    @ManyToMany(mappedBy = "asuntos")
    @JsonIgnore
    private Set<Procurador> procuradores;



    @Override
    public int hashCode() {
        return Objects.hash(id); // Usa solo el ID para evitar referencias circulares
    }
}