package com.g7p44.viajes_ms.repositories;

import com.g7p44.viajes_ms.models.Conductor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConductorRepository extends MongoRepository <Conductor, String> {

    List<Conductor> findByDisponible(Boolean disponible);

};
