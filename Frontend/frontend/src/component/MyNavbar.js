import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css'; // Import Font Awesome CSS (optional for icons)
import './navbar.css'; // Import your custom CSS

function MyNavbar() {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Navbar.Brand href="#">BookWorm</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <Nav.Link href="#" className="nav-link-custom">Home</Nav.Link>
          <Nav.Link href="#" className="nav-link-custom">Categories</Nav.Link>
          <Nav.Link href="#" className="nav-link-custom">Authors</Nav.Link>
        </Nav>
        <Nav className="ml-auto">
          <Nav.Link href="#" className="nav-link-custom">
            <i className="fas fa-shopping-cart"></i> <b>Cart</b>
          </Nav.Link>
          <Nav.Link href="#" className="nav-link-custom">
            <i className="fas fa-user"></i> Sign Up
          </Nav.Link>
          <Nav.Link href="#" className="nav-link-custom">
            <i className="fas fa-sign-in-alt"></i> Login
          </Nav.Link>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}

export default MyNavbar;
