import React, { useState, useEffect } from 'react';
import './CustomerRegistration.css'; // Import the CSS file

const CustomerRegistration = () => {
  const [customers, setCustomers] = useState([]);
  const [customer, setCustomer] = useState({
    customerName: '',
    customerEmail: '',
    customerPassword: '',
    phoneNumber: '',
    pan: '',
  });




  const handleChange = (e) => {
    const { name, value } = e.target;
    setCustomer((prevCustomer) => ({
      ...prevCustomer,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/api/customers', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(customer),
      });
      if (response.ok) {
       
        setCustomer({
          customerName: '',
          customerEmail: '',
          customerPassword: '',
          phoneNumber: '',
          pan: '',
        });
      } else {
        console.error('Error creating customer:', response.statusText);
      }
    } catch (error) {
      console.error('Error creating customer:', error);
    }
  };

  return (
    <div className="page-container">
      <div className="container" >
        <h2>Customer Registration</h2>
        <form onSubmit={handleSubmit}>
          <div>
            <label>Customer Name:</label>
            <input
              type="text"
              name="customerName"
              value={customer.customerName}
              onChange={handleChange}
            />
          </div>
          <br></br>
          <div>
            <label>Customer Email:</label>
            <input
              type="email"
              name="customerEmail"
              value={customer.customerEmail}
              onChange={handleChange}
            />
          </div>
          <br></br>
          <div>
            <label>Customer Password:</label>
            <input
              type="password"
              name="customerPassword"
              value={customer.customerPassword}
              onChange={handleChange}
            />
          </div>
          <br></br>
          <div>
            <label>Phone Number:</label>
            <input
              type="text"
              name="phoneNumber"
              value={customer.phoneNumber}
              onChange={handleChange}
            />
          </div>
          <br></br>
          <div>
            <label>PAN:</label>
            <input
              type="text"
              name="pan"
              value={customer.pan}
              onChange={handleChange}
            />
          </div>
          <br></br>
          <button type="submit">Register</button>
        </form>

        
        <ul>
          {customers.map((customer) => (
            <li key={customer.customerId}>
              {customer.customerName} - {customer.customerEmail}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default CustomerRegistration;
