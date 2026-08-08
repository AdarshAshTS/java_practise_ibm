import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { Loginform } from '../loginform/loginform';

@NgModule({
  imports: [CommonModule, ReactiveFormsModule, Loginform],
  exports: [Loginform]
})
export class AuthModule {}
