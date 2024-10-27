import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoPersonajesComponent } from './components/listado-personajes/listado-personajes.component';
import { FormularioPersonajeComponent } from './components/formulario-personaje/formulario-personaje.component';

const routes: Routes = [
  {path: 'personajes', component: ListadoPersonajesComponent},
  {path: 'formulario', component: FormularioPersonajeComponent},
  {path: '', redirectTo: '/personajes', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
