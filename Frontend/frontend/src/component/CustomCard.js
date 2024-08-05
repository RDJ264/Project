import React from 'react';
import { Card } from 'react-bootstrap';
import './card.css'; // Create a separate CSS file for card styling
import Heading from '../component/Heading';
import { Link } from 'react-router-dom';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';
import CostInfo from './CostInfo';
function CustomCard({ imgSrc, title, rating,page,id,price }) {
  return (
    <div>    
    <div className="card1">
    <div><img src={imgSrc} className="c1" alt="" srcset=""/></div>
    <div className="info">
    <div className="heading"><Heading title={title}></Heading></div>
    <div className="heading"><CostInfo title={price}></CostInfo></div>
    {
      page=="Category Page"?<Link as={Link} to={`/addtocart/${id}`} className="nav-link-custom">Add to cart</Link>:""
    }
</div>
</div>

</div>
  );
}

export default CustomCard;