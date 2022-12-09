import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatButtonModule} from '@angular/material/button';
import { ShappersComponent } from './views/shappers/shappers.component';
import { CadastroshaperComponent } from './views/cadastroshaper/cadastroshaper.component';
import { CadastrolojistaComponent } from './views/cadastrolojista/cadastrolojista.component';
import {MatTabsModule} from '@angular/material/tabs';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import { NgxMaskModule, IConfig } from 'ngx-mask';
import { DashboardShapperComponent } from './views/dashboard-shapper/dashboard-shapper.component'

export const options: Partial<null|IConfig> | (() => Partial<IConfig>) = null;


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ShappersComponent,
    CadastroshaperComponent,
    CadastrolojistaComponent,
    DashboardShapperComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatIconModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
    MatSnackBarModule,
    MatButtonModule,
    MatTabsModule,
    HttpClientModule,
    MatCheckboxModule,
    MatRadioModule,
    NgxMaskModule.forRoot(),


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
