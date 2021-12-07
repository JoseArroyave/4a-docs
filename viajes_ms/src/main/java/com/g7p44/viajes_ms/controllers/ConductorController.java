package com.g7p44.viajes_ms.controllers;

import com.g7p44.viajes_ms.models.Conductor;
import com.g7p44.viajes_ms.exceptions.ConductorNoDisponibleException;
import com.g7p44.viajes_ms.repositories.ConductorRepository;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class ConductorController {

    private final ConductorRepository conductorRepository;


    public ConductorController (ConductorRepository conductorRepository){
        this.conductorRepository = conductorRepository;
    }

    // Crea un conductor
    @PostMapping("/conductor")
    Conductor newAccount(@RequestBody Conductor conductor){
        return conductorRepository.save(conductor);
    }
    //Consulta un conductor enviando su cédula
    @GetMapping("/conductor/{cedula}")
    Conductor getConductor(@PathVariable String cedula){
        return conductorRepository.findById(cedula)
                .orElseThrow(() -> new ConductorNoDisponibleException("No se encontró un conductor con el documento: " +
                        cedula)
                );
    }
    //Consulta una lista de  conductores con disponible true
    @GetMapping("/conductor/disponibles")
    List<Conductor> getConductorDisponible(){
        return conductorRepository.findByDisponible(true);
    }
    //Consulta una conductor de los disponibles aleatoriamente
    @GetMapping("/conductor/elegido")
    Conductor getConductorElegido(){
        List <Conductor> conductoresDisponibles = conductorRepository.findByDisponible(true);
        Random rand = new Random();
        Conductor conductorElegido = conductoresDisponibles.get(rand.nextInt(conductoresDisponibles.size()));
        return conductorElegido;
    }
}
