import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Personaje } from '../interfaces/personaje.interface';

@Injectable({
  providedIn: 'root'
})
export class PersonajesService {

  API_URL = "http://localhost:9000/api/personaje"
  constructor(private http: HttpClient) { }

  getPersonajes(): Observable<Personaje[]> {

    return this.http.get(this.API_URL) as Observable<Personaje[]>;
  }
}
