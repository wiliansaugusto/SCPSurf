import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatSidenavModule} from '@angular/material/sidenav';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatExpansionModule} from '@angular/material/expansion';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './views/home/home.component';
import { PoliticaComponent } from './views/politica/politica.component';
import { NavComponent } from './views/nav/nav.component';
import { FooterComponent } from './views/footer/footer.component';
import { QuemComponent } from './views/quem/quem.component';
import { ContatoComponent } from './core/contato/contato.component';
import { ThanksComponent } from './core/thanks/thanks.component';
import { YouTubePlayerModule } from "@angular/youtube-player";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PoliticaComponent,
    NavComponent,
    FooterComponent,
    QuemComponent,
    ContatoComponent,
    ThanksComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatFormFieldModule,
    MatSelectModule,
    NgbModule,
    MatIconModule,
    MatDividerModule,
    MatExpansionModule,
    YouTubePlayerModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
