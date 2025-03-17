package com.juridico.juridico.repositorio;




import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.juridico.juridico.modelo.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Modifying
    @Query("DELETE FROM Cliente c WHERE c.dni = :dni")
    void deleteByDni(@Param("dni") Long dni);

    
    @Query("SELECT c FROM Cliente c WHERE c.dni = :dni")
    Optional<Cliente> findByDni(Long dni);

    
}
