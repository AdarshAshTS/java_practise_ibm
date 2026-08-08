import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserName = '';
  private currentAccountNumber = '';

  setUserName(username: string): void {
    this.currentUserName = username.trim();
  }

  getUserName(): string {
    return this.currentUserName;
  }

  setAccountNumber(accountNumber: string): void {
    this.currentAccountNumber = accountNumber.trim();
  }

  getAccountNumber(): string {
    return this.currentAccountNumber;
  }

  clearUserName(): void {
    this.currentUserName = '';
    this.currentAccountNumber = '';
  }
}
