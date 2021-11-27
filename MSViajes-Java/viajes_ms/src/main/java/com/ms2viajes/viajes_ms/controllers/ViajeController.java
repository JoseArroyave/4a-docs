package com.ms2viajes.viajes_ms.controllers;

import com.ms2viajes.viajes_ms.exceptions.ConductorNoDisponibleException;
import com.ms2viajes.viajes_ms.models.Conductor;
import com.ms2viajes.viajes_ms.repositories.ConductorRepository;
import com.ms2viajes.viajes_ms.models.Viaje;
import com.ms2viajes.viajes_ms.repositories.ViajeRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ViajeController {

    private final ViajeRepository viajeRepository;
    private final ConductorRepository conductorRepository;

    public ViajeController (ViajeRepository viajeRepository, ConductorRepository conductorRepository){
        this.conductorRepository = conductorRepository;
        this.viajeRepository = viajeRepository;
    }
    //Crea un viaje, actualiza el conductor a No disponible
    @PostMapping("/viaje")
    Viaje nuevoViaje (@RequestBody Viaje viaje){
        Viaje viajeGuardado = viajeRepository.save(viaje);
        Conductor conductorElegido = conductorRepository.findById(viajeGuardado.getConductor()).orElse(null);
        conductorElegido.setDisponible(false);
        conductorElegido.setBalance(conductorElegido.getBalance()+viajeGuardado.getPrecio());
        return viajeGuardado;
    }

    //Consulta los viajes por conductor enviando la cedula (Id) del conductor en la URL
    @GetMapping("viajes/{cedula}")
    List <Viaje> conductorViaje(@PathVariable String cedula){
        Conductor conductor = conductorRepository.findById(cedula).orElse(null);

        if (conductor==null)
            throw new ConductorNoDisponibleException("No se encontró ningún conductor con el documento ingresado");

        List<Viaje> viajes=viajeRepository.findByConductor(cedula);
        return  viajes;
    }
    //Cuando el viaje ha terminado, se cambia su estado a activo false y el estado del conductor a disponible true
    @PutMapping("viaje/terminado/{id}")
    Viaje viajeTerminado (@PathVariable String id){

        Viaje viajeTerminado = viajeRepository.findById(id).orElse(null);
        viajeTerminado.setActivo(false);
        Conductor conductorViaje = conductorRepository.findById( viajeTerminado.getConductor()).orElse(null);
        conductorViaje.setDisponible(true);
        return viajeTerminado;
    }
}
