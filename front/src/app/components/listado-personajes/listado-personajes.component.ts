import { Component, OnInit } from '@angular/core';
import { PersonajesService } from '../../services/personajes.service';
import { Personaje } from '../../interfaces/personaje.interface';

@Component({
  selector: 'app-listado-personajes',
  templateUrl: './listado-personajes.component.html',
  styleUrl: './listado-personajes.component.css'
})
export class ListadoPersonajesComponent implements OnInit{

  listadoPersonajes: Personaje[] = [];

  constructor(private service: PersonajesService){}

  getPersonajes(): void {

    this.service.getPersonajes().subscribe(res => {

      this.listadoPersonajes = res;
    })
  }

  ngOnInit(): void {
      this.getPersonajes();
  }
}
