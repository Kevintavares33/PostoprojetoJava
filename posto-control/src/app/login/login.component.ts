import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}
  onLogin() {
    const credentials = {
      username: this.username,
      password: this.password
    };
  
    this.authService.login(credentials).subscribe(
      (response: any) => {
        const token = response.token;
     
        this.router.navigate(['/abastecimento']);
      },
      (error: any) => {
        console.error('Erro durante o login:', error);
        
      }
    );
  }
}  