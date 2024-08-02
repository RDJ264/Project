// src/App.js

import React, { useEffect, useState } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import CustomCard from './component/CustomCard';
import MyNavbar from './component/MyNavbar';
function fetchAttributes() {
  fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => console.log(data))
      .catch(error => console.error('Error:', error));
}
const cardData = [
  {
    title: 'Card 1',
    content: 'This is the content of card 1.',
    imageUrl: 'https://via.placeholder.com/150'
  },
  {
    title: 'Card 2',
    content: 'This is the content of card 2.',
    imageUrl: 'https://via.placeholder.com/150'
  },
  {
    title: 'Card 3',
    content: 'This is the content of card 3.',
    imageUrl: 'https://via.placeholder.com/150'
  }
];

function App() {
  const [card,setCard]=useState([])
  useEffect(()=>{
    fetch('http://localhost:8080/api/products')
    .then(response => response.json())
    .then(data => setCard(data))
    .catch(error => console.error('Error:', error));
  },[])
  return (
    <div>
    {console.log(card)}
    <div>
    <MyNavbar></MyNavbar>
    </div>
    <div>
    <Container>
      <Row>
        {cardData.map((card, index) => (
          <Col md={4} key={index}>
            <CustomCard
              title={card.title}
              content={card.content}
              imageUrl={card.imageUrl}
            />
          </Col>
        ))}
      </Row>
    </Container>
    </div>
    </div>);
}

export default App;
