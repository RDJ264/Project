import React, { useEffect, useState } from 'react';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';
import { FaShoppingCart, FaUser, FaSignInAlt } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import './navbar.css'; // Import a CSS file for additional styling if needed

function MyNavbar() {
  const [producttype, setProductType] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/product-types/getall')
      .then(res => res.json())
      .then(data => setProductType(data))
      .catch(error => console.log(error));
  }, []);

  return (
    <Navbar bg="dark" variant="dark" sticky="top" expand="lg">
      <Navbar.Brand as={Link} to="/">BookWorm</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <Nav.Link as={Link} to="/" active className="nav-link-custom">Home</Nav.Link>
          <NavDropdown title="Categories" id="basic-nav-dropdown" className="nav-link-custom">
            {producttype.map(pt => (
               <NavDropdown.Item key={pt.id} as={Link} to={`/category/${pt.id}`}>
               {pt.name}
             </NavDropdown.Item>
            ))}
          </NavDropdown>
          <Nav.Link as={Link} to="/authors" className="nav-link-custom">Authors</Nav.Link>
          <Nav.Link as={Link} to="/cart" className="nav-link-custom">
            <FaShoppingCart /> <b>Cart</b>
          </Nav.Link>
          <Nav.Link as={Link} to="/signup" className="nav-link-custom">
            <FaUser /> Sign Up
          </Nav.Link>
          <Nav.Link as={Link} to="/login" className="nav-link-custom">
            <FaSignInAlt /> Login
          </Nav.Link>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}

export default MyNavbar;
