import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AbastecimentoService {
  private apiUrl = 'http://localhost:8080/abastecimento'; 

  constructor(private http: HttpClient) {}

  registrarAbastecimento(abastecimento: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/abastecimento`, abastecimento);
  }
}
