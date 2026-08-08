import { useState } from "react";

function Account({ balance, setBalance }) {

  const [deposit, setDeposit] = useState("");
  const [withdraw, setWithdraw] = useState("");

  const [transactions, setTransactions] = useState([]);

  const depositAmount = () => {
    const amount = Number(deposit);
    const updatedBalance = balance + amount;

    setBalance(updatedBalance);

    setTransactions(prev => [
      ...prev,
      {
        id: Date.now(),
        type: "Deposit",
        amount,
        balanceAfter: updatedBalance
      }
    ]);

    setDeposit("");
  };

  const withdrawAmount = () => {
    const amount = Number(withdraw);
    const updatedBalance = balance - amount;

    if (updatedBalance < 0) {
      alert("Insufficient Balance");
      return;
    }

    setBalance(updatedBalance);

    setTransactions(prev => [
      ...prev,
      {
        id: Date.now(),
        type: "Withdrawal",
        amount,
        balanceAfter: updatedBalance
      }
    ]);

    setWithdraw("");
  };

  return (
    <div>
      <h1>Account</h1>

      <h3>Current Balance: ₹{balance}</h3>

      <h4>Deposit</h4>

      <input
        type="number"
        value={deposit}
        onChange={(e) => setDeposit(e.target.value)}
        placeholder="Enter deposit amount"
      />

      <button onClick={depositAmount}>
        Deposit
      </button>

      <h4>Withdraw</h4>

      <input
        type="number"
        value={withdraw}
        onChange={(e) => setWithdraw(e.target.value)}
        placeholder="Enter withdrawal amount"
      />

      <button onClick={withdrawAmount}>
        Withdraw
      </button>

      <h2>Transactions</h2>

      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Amount</th>
            <th>Balance After</th>
          </tr>
        </thead>

        <tbody>
          {transactions.map((txn) => (
            <tr key={txn.id}>
              <td>{txn.id}</td>
              <td>{txn.type}</td>
              <td
                style={{
                    color: txn.type === "Deposit" ? "green" : "red"
                }}
              >
                ₹{txn.amount}
              </td>
              <td>₹{txn.balanceAfter}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Account;