package com.salesianostriana.dam.personajesjajosos.controller;

import com.salesianostriana.dam.personajesjajosos.dto.GetPersonajeDto;
import com.salesianostriana.dam.personajesjajosos.model.Personaje;
import com.salesianostriana.dam.personajesjajosos.service.PersonajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personaje")
@RequiredArgsConstructor
public class PersonajeController {

    private final PersonajeService service;


    @GetMapping
    public ResponseEntity<List<GetPersonajeDto>> mostrarTodos() {

        List<Personaje> data = service.findAll();

        List<GetPersonajeDto> response = data.stream()
                .map(GetPersonajeDto::of).toList();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPersonajeDto> mostrarPorId(@PathVariable Long id) {

        Optional<Personaje> optionalPersonaje = service.findById(id);

        return optionalPersonaje.map(personaje -> new ResponseEntity<>(GetPersonajeDto.of(personaje), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Personaje> guardar(@RequestBody Personaje p) {

        return new ResponseEntity<>(service.save(p), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Personaje> editar(@RequestBody Personaje p, @PathVariable Long id) {

        Personaje editar = service.edit(p, id);
        if(editar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(editar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){

        Optional<Personaje> optionalPersonaje = service.findById(id);

        if(optionalPersonaje.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        service.delete(optionalPersonaje.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
