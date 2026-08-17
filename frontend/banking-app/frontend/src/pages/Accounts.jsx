import React from "react";
import AccountDetails from "../components/AccountDetails";
import Transactions from "../components/Transactions";


function Accounts() {
   return (
       <div>
           <h1>Your Accounts</h1>
           <AccountDetails />
           <Transactions />
       </div>
   );
}


export default Accounts;
