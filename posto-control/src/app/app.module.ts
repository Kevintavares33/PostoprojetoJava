import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AbastecimentoComponent } from './abastecimento/abastecimento.component';
import { BombaComponent } from './bomba/bomba.component';
import { TanqueComponent } from './tanque/tanque.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';


import { MatSnackBarModule } from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    AbastecimentoComponent,
    BombaComponent,
    TanqueComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    // Adicione os módulos do Angular Material aqui
    MatSnackBarModule,
    BrowserAnimationsModule,
    // Adicione outros módulos do Angular Material conforme necessário
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
