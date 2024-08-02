import React from 'react';
import { Card } from 'react-bootstrap';
import './card.css'; // Create a separate CSS file for card styling

function CustomCard({ imgSrc, title, rating }) {
  return (
    <Card className="card1">
      <Card.Img variant="top" src={imgSrc} className="c1" />
      <Card.Body className="info">
        <Card.Title>{title}</Card.Title>
        <Card.Text>
          <img src="/path/to/star.jpg" className="star" alt="Rating" /> {rating}
        </Card.Text>
      </Card.Body>
    </Card>
  );
}

export default CustomCard;