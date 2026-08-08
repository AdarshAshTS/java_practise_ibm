import { Component } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import {
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-loginform',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './loginform.html',
  styleUrl: './loginform.css'
})
export class Loginform {

  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private authService: AuthService) {

    this.loginForm = this.fb.group({
      username: ['adarsh', Validators.required],
      password: ['123456', [Validators.required, Validators.pattern(/^\d{6}$/)]],
      accountNumber: ['123456789012', [Validators.required, Validators.pattern(/^\d{12}$/)]]
    });

  }

  submit() {

    if (this.loginForm.valid) {
      const username = this.loginForm.get('username')?.value;
      this.authService.setUserName(username);
      this.authService.setAccountNumber(this.loginForm.get('accountNumber')?.value);
      console.log('Login successful', this.loginForm.value);
      this.loginForm.reset();
      this.router.navigate(['/dashboard']);
    }

  }

}