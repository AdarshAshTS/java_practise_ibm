import { createContext, useState } from "react";
export const BankContext = createContext();

export function BankProvider({ children }) {
    const [balance, setBalance] = useState(1000);
    const user = {
        name: "Adarsh",
        accountNumber: "1234567890"
    };
    return (
        <BankContext.Provider
            value={{
                balance,
                setBalance,
                user
            }}
        >
            {children}
        </BankContext.Provider>
    );
}