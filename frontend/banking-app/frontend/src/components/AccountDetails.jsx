import React, { useEffect, useState } from "react";

function AccountDetails() {
    const [account, setAccount] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch("https://api.examplebank.com/accounts/12345")
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Failed to fetch account details");
                }
                return response.json();
            })
            .then((data) => {
                setAccount(data);
                setLoading(false);
            })
            .catch((error) => {
                setError(error.message);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return <p>Loading account details...</p>;
    }

    if (error) {
        return <p>Error: {error}</p>;
    }

    return (
        <div>
            <h2>Account Details</h2>

            {account && (
                <div>
                    <p>Account Number: {account.accountNumber}</p>
                    <p>Account Holder: {account.holderName}</p>
                    <p>Balance: ₹{account.balance}</p>
                </div>
            )}
        </div>
    );
}

export default AccountDetails;