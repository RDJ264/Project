// src/App.js

import React, { useEffect, useState } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import CustomCard from './component/CustomCard';
import MyNavbar from './component/MyNavbar';
import HeadingPage from './component/HeadingPage';
import "./App.css"
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
    <div>
    <MyNavbar></MyNavbar>
    </div>
    <div style={{marginLeft:"493px",marginTop:"33px"}}>
      <HeadingPage title="Home Page"></HeadingPage>
    </div>
    <div className='cards'>
    
        {card.map((card, index) => (
          
          <Col md={4} key={index}>
            <CustomCard
              title={card.productEnglishName
              }
              content={card.content}
              imgSrc={card.productImage}
            />
          </Col>
        ))}
      
    
    </div>
    </div>);
}

export default App;
