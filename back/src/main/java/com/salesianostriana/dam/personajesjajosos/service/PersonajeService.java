package com.salesianostriana.dam.personajesjajosos.service;

import com.salesianostriana.dam.personajesjajosos.model.Personaje;
import com.salesianostriana.dam.personajesjajosos.repository.PersonajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonajeService {

    private final PersonajeRepository repo;


    public List<Personaje> findAll() {

        return repo.findAll();
    }

    public Optional<Personaje> findById(Long id) {

        return repo.findById(id);
    }

    public Personaje save (Personaje p) {

        return repo.save(p);
    }

    public Personaje edit(Personaje p, Long id) {

        Optional<Personaje> optionalPersonaje = repo.findById(id);

        if(optionalPersonaje.isEmpty())
            return null;

        Personaje antiguo = optionalPersonaje.get();

        antiguo.setPhotoUrl(p.getPhotoUrl());

        return antiguo;
    }

    public void delete(Personaje p) {

        repo.delete(p);
    }

    public void deleteById(Long id){

        repo.deleteById(id);
    }
}
