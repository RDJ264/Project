import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Toast } from 'react-bootstrap'; // Import Toast for messages
import './card.css'; // Create a separate CSS file for card styling
import Heading from '../component/Heading';
import CostInfo from './CostInfo';

function CustomCard({ imgSrc, title, page, id, price, isLoggedIn, cartdetailsid, onDelete, refresh,transtype }) {
  const navigate = useNavigate();
  const [message, setMessage] = useState(null); // State for message

  const checkIfProductInCart = async (customerId, productId) => {
    try {
      const response = await fetch(`http://localhost:8080/api/cartDetails/check/${customerId}/${productId}`);
      if (response.ok) {
        const data = await response.json();
        return data.exists;
      } else {
        console.error('Failed to check product in cart');
        return false;
      }
    } catch (error) {
      console.error('Error checking product in cart:', error);
      return false;
    }
  };

  const handleAddToCartClick = async () => {
    if (!isLoggedIn) {
      navigate('/login');
    } else {
      const customerId = localStorage.getItem('customerId');
      if (customerId) {
        const isProductInCart = await checkIfProductInCart(customerId, id);

        if (isProductInCart) {
          
          setMessage({ type: 'error', text: 'Product already in cart' });
          return; // Prevent adding duplicate product
        }

        const productPayload = JSON.stringify({
          product: {
            productId: id
          }
        });

        try {
          const response = await fetch(`http://localhost:8080/api/cartDetails/${customerId}`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: productPayload
          });

          if (response.ok) {
            console.log('Product added to cart successfully');
            setMessage({ type: 'success', text: 'Product added to cart successfully!' });
            if (refresh) {
              refresh(); // Call the refresh function passed from the parent component
            }
          } else {
            console.error('Failed to add product to cart');
            const errorData = await response.text();
            console.error('Product Error details:', errorData);
            setMessage({ type: 'error', text: 'Failed to add product to cart. Please try again.' });
          }
        } catch (error) {
          console.error('Product Request Error:', error);
          setMessage({ type: 'error', text: 'Error occurred while adding product to cart.' });
        }
      } else {
        console.error('Customer ID not found');
        setMessage({ type: 'error', text: 'Customer ID not found. Please log in.' });
      }
    }
  };

  const handleDeleteClick = async () => {
    if (onDelete) {
      onDelete(); // Call the onDelete function passed from the parent component
    }
  };

  return (
    <div>
      <div className="card1">
        <div><img src={imgSrc} className="c1" alt="" /></div>
        <div className="info">
          <div className="heading"><Heading title={title} /></div>
          <div className="heading"><CostInfo title={price} /></div>
          {transtype === 'B' && <div className="text-success fw-bold mt-2">Purchased</div>}
          {page === "Category Page" && (
            <Button className="nav-link-custom" onClick={handleAddToCartClick}>
              Add to cart
            </Button>
          )}
          {page === "Cart Page" && (
            <Button 
              variant="danger" 
              style={{ marginTop: '10px' }}
              onClick={handleDeleteClick}
            >
              Delete
            </Button>
          )}
        </div>
      </div>

      {/* Display message if available */}
      {message && (
        <div className="toast-container">
          <Toast bg={message.type === 'success' ? 'success' : 'danger'} onClose={() => setMessage(null)} delay={3000} autohide>
            <Toast.Body>{message.text}</Toast.Body>
          </Toast>
        </div>
      )}
    </div>
  );
}

export default CustomCard;
