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
import LoginPage from './Pages/LoginPage';
import PrivateRoute from './component/PrivateRoute';
import CartPage from './Pages/CartPage';
import Invoice from './Pages/Invoice';
import MyShelf from './Pages/MyShelf';
import MyLibrary from './Pages/MyLibrary';
import UserLib from './Pages/UserLib';
import LibraryDetails from './Pages/LibraryDetails';
function App() {
  const [card, setCard] = useState([]);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setCard(data))
      .catch(error => console.error('Error:', error));
    
    // Check login status from localStorage or API on app load
    const loggedInStatus = localStorage.getItem('isLoggedIn') === 'true';
    setIsLoggedIn(loggedInStatus);
  }, []);

  const handleLogin = (success) => {
    if (success) {
      setIsLoggedIn(true);
      localStorage.setItem('isLoggedIn', 'true');
    }
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('cartId')
    localStorage.removeItem('customerId')
    // Redirect to login page if needed
  };

  return (
    <div>
    <Router>
      <div>
        <MyNavbar isLoggedIn={isLoggedIn} onLogout={handleLogout} />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/category/:id" element={<CategoryPage isLoggedIn={isLoggedIn} />} />
          <Route path="/login" element={<LoginPage onLogin={handleLogin} />} />
          <Route path="/cart" element={<PrivateRoute isLoggedIn={isLoggedIn} element={CartPage} />} />
          <Route path="/invoice" element={<Invoice></Invoice>}></Route>
         <Route path="/shelf" element={<PrivateRoute isLoggedIn={isLoggedIn} element={MyShelf} />} ></Route>
         <Route path="/mylibrary" element={<PrivateRoute isLoggedIn={isLoggedIn} element={MyLibrary} />} ></Route>
         <Route path="/libraryuser" element={<PrivateRoute isLoggedIn={isLoggedIn} element={UserLib} />} ></Route>
        <Route path="/librarydetails" element={<PrivateRoute isLoggedIn={isLoggedIn} element={LibraryDetails}/>}></Route>
        </Routes>
      </div>
    </Router>
    </div>
  );
}

export default App;