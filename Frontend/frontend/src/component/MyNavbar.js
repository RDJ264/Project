import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import { FaShoppingCart, FaUser, FaSignInAlt } from 'react-icons/fa';
import './navbar.css'; // Import a CSS file for additional styling if needed

function CustomNavbar() {
  return (
    <Navbar bg="dark" variant="dark" sticky="top" expand="lg">
      <Navbar.Brand href="#">BookWorm</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <Nav.Link href="#" active className="nav-link-custom">Home</Nav.Link>
          <Nav.Link href="#" className="nav-link-custom">Categories</Nav.Link>
          <Nav.Link href="#" className="nav-link-custom">Authors</Nav.Link>
        
          <Nav.Link href="#" className="nav-link-custom">
            <FaShoppingCart /> <b>Cart</b>
          </Nav.Link>
          <Nav.Link href="#" className="nav-link-custom">
            <FaUser /> Sign Up
          </Nav.Link>
          <Nav.Link href="#" className="nav-link-custom">
            <FaSignInAlt /> Login
          </Nav.Link>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}

export default CustomNavbar;
