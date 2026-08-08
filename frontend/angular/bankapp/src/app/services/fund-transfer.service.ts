import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Transaction } from './transaction';
import { NotificationService } from './notificationService';

@Injectable({
  providedIn: 'root'
})
export class FundTransferService {
  private readonly transactions: Transaction[] = [
    { accountNumber: '123456789012', amount: 250 },
    { accountNumber: '987654321098', amount: 500 }
  ];

  constructor(private readonly notificationService: NotificationService) {}

  createTransaction(accountNumber: string, amount: number): Observable<Transaction> {
    const payload: Transaction = { accountNumber, amount };
    this.transactions.push(payload);
    this.notificationService.notifyUser('transaction done!');
    return of(payload);
  }

  getTransactions(): Observable<Transaction[]> {
    return of(this.transactions);
  }
}