import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard';
import { TransactionsComponent } from './transactions/transactions';
import { Loginform } from './loginform/loginform';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: Loginform
    },
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: 'transaction',
        component: TransactionsComponent
    }
];
