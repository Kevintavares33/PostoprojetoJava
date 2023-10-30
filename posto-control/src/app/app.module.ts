import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AbastecimentoComponent } from './abastecimento/abastecimento.component';
import { BombaComponent } from './bomba/bomba.component';
import { TanqueComponent } from './tanque/tanque.component';

@NgModule({
  declarations: [
    AppComponent,
    AbastecimentoComponent,
    BombaComponent,
    TanqueComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
