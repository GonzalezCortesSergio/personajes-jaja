import { Component, Input } from '@angular/core';
import { PersonajesService } from '../../services/personajes.service';
import { PersonajeDto } from '../../models/personaje.dto';

@Component({
  selector: 'app-formulario-personaje',
  templateUrl: './formulario-personaje.component.html',
  styleUrl: './formulario-personaje.component.css'
})
export class FormularioPersonajeComponent {

  personaje = new PersonajeDto("", "")

  constructor(private service: PersonajesService){}

  savePersonaje(): void {

    this.service.savePersonaje(this.personaje);
  }
 }
