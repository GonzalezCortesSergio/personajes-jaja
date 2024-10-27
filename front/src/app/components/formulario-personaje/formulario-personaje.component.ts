import { Component, Input } from '@angular/core';
import { Personaje } from '../../interfaces/personaje.interface';
import { PersonajesService } from '../../services/personajes.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-formulario-personaje',
  templateUrl: './formulario-personaje.component.html',
  styleUrl: './formulario-personaje.component.css'
})
export class FormularioPersonajeComponent {

  personaje: Personaje = 
  {
    id: 0,
    nombre: "",
    photoUrl: ""
  }

  constructor(private http: HttpClient){}

  savePersonaje(): void {

    this.http.post("http://localhost:9000/api/personaje",this.personaje);
  }
 }
