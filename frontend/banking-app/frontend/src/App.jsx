import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

import Home from "./pages/Home";
import Accounts from "./pages/Accounts";
import About from "./pages/About";
import BalanceController from "./components/BalanceController";
import { useSelector, useDispatch } from "react-redux";

function App() {
  const balance = useSelector((state) => state.balance);

    const dispatch = useDispatch();

    return (
        <BrowserRouter>
            <div>
                <Link to="/">Home</Link>{" | "}
                <Link to="/accounts">Accounts</Link>{" | "}
                <Link to="/about">About</Link>
            </div>

            <hr />

            <h2>Current Balance: ₹{balance}</h2>

            <BalanceController/>

            <hr />
            
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/accounts" element={<Accounts />} />
                <Route path="/about" element={<About />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;