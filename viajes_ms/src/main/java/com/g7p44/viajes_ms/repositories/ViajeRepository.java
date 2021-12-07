package com.g7p44.viajes_ms.repositories;

import com.g7p44.viajes_ms.models.Viaje;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ViajeRepository extends MongoRepository<Viaje, String> {

    List <Viaje> findByCliente(String cliente);
    List <Viaje> findByConductor(String conductor);
}
