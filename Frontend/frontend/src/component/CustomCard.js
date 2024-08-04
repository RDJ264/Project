import React from 'react';
import { Card } from 'react-bootstrap';
import './card.css'; // Create a separate CSS file for card styling
import Heading from './Heading';
function CustomCard({ imgSrc, title, rating }) {
  return (
    
    <div className="card1">
    <div><img src={imgSrc} className="c1" alt="" srcset=""/></div>
    <div className="info">
    <div className="heading">{title}</div>
</div>

</div>
  );
}

export default CustomCard;