import { Component, Input } from '@angular/core';
import { Personaje } from '../../interfaces/personaje.interface';
import { PersonajesService } from '../../services/personajes.service';

@Component({
  selector: 'app-formulario-personaje',
  templateUrl: './formulario-personaje.component.html',
  styleUrl: './formulario-personaje.component.css'
})
export class FormularioPersonajeComponent {

  personaje = {
    nombre: "",
    photoUrl: ""
  };

  constructor(private service: PersonajesService){}

  savePersonaje(): void {

    this.service.savePersonaje(<Personaje>this.personaje);
  }
 }
