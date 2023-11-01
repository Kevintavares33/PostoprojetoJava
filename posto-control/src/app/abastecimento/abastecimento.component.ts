import { Component } from '@angular/core';
import { AbastecimentoService } from './abastecimento.service';

@Component({
  selector: 'app-abastecimento',
  templateUrl: './abastecimento.component.html',
  styleUrls: ['./abastecimento.component.css']
})
export class AbastecimentoComponent {
  selectedBomba!: string;
  selectedCombustivel!: string;
  litros!: number;
  valor!: number;
  
  constructor(private abastecimentoService: AbastecimentoService) {}

  registrarAbastecimento() {
    const abastecimento = {
      bomba: this.selectedBomba,
      combustivel: this.selectedCombustivel,
      litros: this.litros,
      valor: this.valor
    };

    this.abastecimentoService.registrarAbastecimento(abastecimento).subscribe(
      response => {
        console.log('Abastecimento registrado com sucesso!', response);
        // Lógica adicional após o registro bem-sucedido, se necessário.
      },
      error => {
        console.error('Erro ao registrar abastecimento:', error);
        // Tratar erros aqui, se necessário.
      }
    );
  }
}
