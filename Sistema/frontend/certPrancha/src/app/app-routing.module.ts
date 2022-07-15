import { ThanksComponent } from './core/thanks/thanks.component';
import { ContatoComponent } from './core/contato/contato.component';
import { QuemComponent } from './views/quem/quem.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { PoliticaComponent } from './views/politica/politica.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'contato', component:ContatoComponent},
  {path:'thanks', component:ThanksComponent},
  {path:'quem', component:QuemComponent},
  {path:'politica', component:PoliticaComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
