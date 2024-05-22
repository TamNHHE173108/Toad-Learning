import React from 'react';
import './Navbar.css';  // Optional: Create a separate CSS file for Navbar styles
import '../nav-bar/Navbar.css';
import logo from '../imgs/logo (1).jpg';

function Navbar() {
  return (
    <nav className="navbar">
      <div className="logo">
        <img src={logo} alt="Logo" className="logo-img" />
      </div>
      <input type="text" placeholder="Search..." className="search-bar" />
      <div className="nav-buttons">
        <button className="login-button">Login</button>
        <button className="join-button">Join for free</button>
      </div>
    </nav>
  );
}

export default Navbar;
