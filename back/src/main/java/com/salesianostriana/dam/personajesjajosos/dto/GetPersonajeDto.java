package com.salesianostriana.dam.personajesjajosos.dto;

import com.salesianostriana.dam.personajesjajosos.model.Personaje;

public record GetPersonajeDto(
        Long id,
        String nombre,
        String photoUrl
) {

    public static GetPersonajeDto of (Personaje p) {

        return new GetPersonajeDto(
                p.getId(),
                p.getNombre(),
                p.getPhotoUrl()
        );
    }
}
