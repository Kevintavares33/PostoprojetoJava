import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService) {}

  onLogin() {
    this.authService.login(this.username, this.password).subscribe(
      ({ token, user }) => {
        console.log('Login bem-sucedido!', token, user);
        // Lógica adicional após o login bem-sucedido, se necessário.
      },
      error => {
        console.error('Erro durante o login:', error);
        // Lógica para lidar com erros aqui.
      }
    );
  }
}
