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

    login() {
        this.authService.login().subscribe(
            (loggedIn: boolean) => {
                if (loggedIn) {
                    console.log('Login bem-sucedido.');
                    // Redireciona para a página de abastecimento após o login bem-sucedido
                    this.router.navigate(['/abastecimento']);
                } else {
                    console.error('Erro de login.');
                    // Trate o erro de login aqui, se necessário
                }
            }
        );
    }
}
