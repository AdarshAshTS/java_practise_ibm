import { Account } from "../models/account";

let accounts: Account[] = [
  { id: 1, name: "adarsh", balance: 5000 },
  { id: 2, name: "momi", balance: 3000 }
];

export const getAccounts = (): Account[] => accounts;

export const getAccountById = (id: number): Account | undefined =>
  accounts.find(acc => acc.id === id);

export const deposit = (id: number, amount: number): Account | undefined => {
  const account = getAccountById(id);
  if (account) account.balance += amount;
  return account;
};

export const withdraw = (id: number, amount: number): Account | undefined => {
  const account = getAccountById(id);
  if (account && account.balance >= amount) account.balance -= amount;
  return account;
};
