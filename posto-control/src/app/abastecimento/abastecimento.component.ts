import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AbastecimentoService } from './abastecimento.service';

@Component({
  selector: 'app-abastecimento',
  templateUrl: './abastecimento.component.html',
  styleUrls: ['./abastecimento.component.css']
})
export class AbastecimentoComponent {
  bombas: any[]; // Defina a lista de bombas aqui
  tiposCombustivel: string[]; // Defina a lista de tipos de combustível aqui
  selectedBomba: number = 1;
  selectedCombustivel: string = 'Gasolina';
  litros: number = 0;
  valor: number = 0;
  isRequesting: boolean = false;

  constructor(private abastecimentoService: AbastecimentoService, private _snackBar: MatSnackBar) {
    // Inicialize suas listas aqui, por exemplo:
    this.bombas = [
      { numero: 1, tipoCombustivel: 'Gasolina' },
      { numero: 2, tipoCombustivel: 'Diesel' }
    ];
    this.tiposCombustivel = ['Gasolina', 'Diesel'];
  }

  registrarAbastecimento() {
    const abastecimento = {
      bomba: this.selectedBomba,
      combustivel: this.selectedCombustivel,
      litros: this.litros,
      valor: this.valor
    };

    this.isRequesting = true;

    this.abastecimentoService.registrarAbastecimento(abastecimento).subscribe(
      response => {
        console.log('Abastecimento registrado com sucesso!', response);
        this.openSnackBar('Abastecimento registrado com sucesso!', 'Fechar');
      },
      error => {
        console.error('Erro ao registrar abastecimento:', error);
        this.openSnackBar('Erro ao registrar abastecimento. Tente novamente mais tarde.', 'Fechar');
      }
    ).add(() => {
      this.isRequesting = false;
    });
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000, // Duração da mensagem (em milissegundos)
    });
  }
}
