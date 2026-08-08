import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FundTransferService } from '../services/fund-transfer.service';
import { Transaction } from '../services/transaction';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-transactions',
  imports: [CommonModule, CurrencyPipe],
  templateUrl: './transactions.html',
  styleUrl: './transactions.css'
})
export class TransactionsComponent implements OnInit {
  transactions: Transaction[] = [];

  constructor(private readonly fundTransferService: FundTransferService) {}

  ngOnInit(): void {
    this.fundTransferService.getTransactions().subscribe((data) => {
      this.transactions = data;
    });
  }
}