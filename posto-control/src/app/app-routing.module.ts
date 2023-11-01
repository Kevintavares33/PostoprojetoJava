import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AbastecimentoComponent } from './abastecimento/abastecimento.component';
import { BombaComponent } from './bomba/bomba.component';
import { TanqueComponent } from './tanque/tanque.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', redirectTo: '/abastecimento', pathMatch: 'full' },
  { path: 'abastecimento', component: AbastecimentoComponent },
  { path: 'bomba', component: BombaComponent },
  { path: 'tanque', component: TanqueComponent },
  { path: 'login', component: LoginComponent } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
