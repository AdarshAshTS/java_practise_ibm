import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FundTransferService } from '../services/fund-transfer.service';
import { AuthService } from '../services/auth.service';
import { PipesModule } from '../pipes/pipes.module';

@Component({
  selector: 'app-dashboard',
  imports: [FormsModule, PipesModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class DashboardComponent {
  accountNumber = '';
  amount: number | null = null;
  errorMessage = '';

  constructor(
    private readonly fundTransferService: FundTransferService,
    private readonly authService: AuthService
  ) {}

  get userName(): string {
    return this.authService.getUserName() || 'User';
  }

  get accountNumberMasked(): string {
    return this.authService.getAccountNumber() || 'Account Number';
  }

  transfer() {
    if (!this.accountNumber.trim()) {
      this.errorMessage = 'Account number is required.';
      return;
    }

    if (this.amount === null || this.amount < 100) {
      this.errorMessage = 'Minimum transfer amount is ₹100.';
      return;
    }

    this.fundTransferService.createTransaction(this.accountNumber, this.amount).subscribe(() => {
      this.errorMessage = '';
      this.accountNumber = '';
      this.amount = null;
    });
  }
}
