import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AbastecimentoComponent } from './abastecimento/abastecimento.component';
import { BombaComponent } from './bomba/bomba.component';
import { TanqueComponent } from './tanque/tanque.component';

const routes: Routes = [
  { path: '', redirectTo: '/abastecimento', pathMatch: 'full' }, // Rota padrão redirecionando para o componente de abastecimento
  { path: 'abastecimento', component: AbastecimentoComponent },
  { path: 'bomba', component: BombaComponent },
  { path: 'tanque', component: TanqueComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
