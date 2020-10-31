import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  showAdminBoard = false;
  username = '';
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService: AuthService, private router:Router,private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().userInfo.role;
      this.showAdminBoard = this.tokenStorage.getUser().userInfo.role.includes('ADMIN');
      this.username = this.tokenStorage.getUser().userInfo.username;
    }
  }

  onSubmit(): void {
    this.authService.login(this.form).subscribe(
      data => {
        this.tokenStorage.saveToken(data.authResponse);
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.showAdminBoard = data.userInfo.role.includes('ADMIN');
        this.roles = this.tokenStorage.getUser().userInfo.role;
        this.username = data.userInfo.username;
        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }

}
