import { useDispatch } from "react-redux";

function BalanceController() {
    const dispatch = useDispatch();

    const deposit = () => {
        dispatch({ type: "DEPOSIT", payload: 1000 });
    };

    const withdraw = () => {
        dispatch({ type: "WITHDRAW", payload: 500 });
    };

    return (
        <div>
            <h3>Balance Controller</h3>
            <button onClick={deposit}>
                Deposit ₹1000
            </button>
            <button onClick={withdraw}>
                Withdraw ₹500
            </button>
        </div>
    );
}

export default BalanceController;