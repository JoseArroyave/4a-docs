package com.ms2viajes.viajes_ms.repositories;

import com.ms2viajes.viajes_ms.models.Conductor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConductorRepository extends MongoRepository <Conductor, String> {

    List<Conductor> findByDisponible(Boolean disponible);
    Conductor findOneDisponible(Boolean disponible);
};
