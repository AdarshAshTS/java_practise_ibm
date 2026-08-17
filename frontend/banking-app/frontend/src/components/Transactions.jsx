import React, { useState, useEffect } from "react";


function Transactions() {
   // State to hold list of transactions
   const [transactions, setTransactions] = useState([]);

   useEffect(() => {
       // 🔄 Fetch transaction history from backend
       fetch("https://api.examplebank.com/accounts/12345/transactions")
           .then((res) => res.json())
           .then((data) => setTransactions(data)) // Save transactions in state
           .catch((err) => console.error(err));   // Log errors
   }, []);


   return (
       <div>
           <h2>Transaction History</h2>
           <ul>
               {/* Loop through transactions and render each */}
               {transactions.map((txn) => (
                   <li key={txn.id}>
                       {txn.date} - {txn.type} - ₹{txn.amount}
                   </li>
               ))}
           </ul>
       </div>
   );
}


export default Transactions;
