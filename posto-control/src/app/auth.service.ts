import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn: boolean = false;

  login(): Observable<boolean> {
    // Simula um login bem-sucedido
    this.loggedIn = true;
    return of(this.loggedIn);
  }

  isLoggedIn(): boolean {
    return this.loggedIn;
  }

  logout(): void {
    // Simula o logout
    this.loggedIn = false;
  }
}
