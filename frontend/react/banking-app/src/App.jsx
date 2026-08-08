import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Navbar from "./components/Navbar";
import Dashboard from "./components/Dashboard";
import Account from "./components/Account";
import { BankProvider } from "./context/BankContext";

function App() {
  return (
    <BankProvider>
      <BrowserRouter>
        <div
          style={{
            display: "flex"
          }}
        >
          <Navbar />
          <div
            style={{
              padding: "20px",
              flex: 1
            }}
          >
            <Routes>
              <Route
                path="/"
                element={<Navigate to="/dashboard" />}
              />
              <Route
                path="/dashboard"
                element={<Dashboard />}
              />
              <Route
                path="/account"
                element={<Account />}
              />
            </Routes>
          </div>
        </div>
      </BrowserRouter>
    </BankProvider>
  );
}

export default App;