import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div
      style={{
        width: "200px",
        height: "100vh",
        backgroundColor: "#eee",
        padding: "20px"
      }}
    >
      <h3>Menu</h3>

      <ul style={{ listStyle: "none", padding: 0 }}>
        <li>
          <Link to="/dashboard">Dashboard</Link>
        </li>

        <li>
          <Link to="/account">Account</Link>
        </li>
      </ul>
    </div>
  );
}

export default Navbar;