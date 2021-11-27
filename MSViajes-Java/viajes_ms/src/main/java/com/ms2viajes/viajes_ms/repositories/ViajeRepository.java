package com.ms2viajes.viajes_ms.repositories;

import com.ms2viajes.viajes_ms.models.Viaje;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ViajeRepository extends MongoRepository<Viaje, String> {

    List <Viaje> findByCliente(String cliente);
    List <Viaje> findByConductor(String conductor);
}
