package com.juridico.juridico.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "procurador")
public class Procurador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "procurador_asunto", joinColumns = @JoinColumn(name = "procurador_id"), inverseJoinColumns = @JoinColumn(name = "asunto_id"))
    private Set<Asunto> asuntos;



    @Override
    public int hashCode() {
        return Objects.hash(id); // Usa solo el ID para evitar la recursión infinita
    }
}
