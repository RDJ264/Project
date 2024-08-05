import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { Container, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import CustomCard from './component/CustomCard';
import HeadingPage from './component/HeadingPage';
import "./App.css";
import MyNavbar from './component/MyNavbar';
import HomePage from './Pages/HomePage';
import CategoryPage from './Pages/CategoryPage';
function App() {
  const [card, setCard] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setCard(data))
      .catch(error => console.error('Error:', error));
  }, []);

  return (
    <Router>
      <div>
        <MyNavbar />
        <Routes>
          <Route path="/" element=
          {<HomePage></HomePage>}></Route>
           <Route path="/category/:id" element={<CategoryPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
