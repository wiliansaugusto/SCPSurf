import { DashboardShapperComponent } from './views/dashboard-shapper/dashboard-shapper.component';
import { CadastrolojistaComponent } from './views/cadastrolojista/cadastrolojista.component';
import { CadastroshaperComponent } from './views/cadastroshaper/cadastroshaper.component';
import { ShappersComponent } from './views/shappers/shappers.component';
import { LoginComponent } from './views/login/login.component';
import { HomeComponent } from './views/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  {path:"", component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"shappers", component:ShappersComponent},
  {path:"cadastrarlojista", component:CadastrolojistaComponent},
  {path:"cadastroshapper", component:CadastroshaperComponent},
  {path:"dashboardshapper", component:DashboardShapperComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
