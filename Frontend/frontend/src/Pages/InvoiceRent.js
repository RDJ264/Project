import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function InvoiceRent() {
  const navigate = useNavigate();
  const [invoiceDetails, setInvoiceDetails] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    fetch(`http://localhost:8080/api/invoice-details/product/${id}`)
      .then(res => res.json())
      .then(data => setInvoiceDetails(data))
      .catch(error => console.error('Error fetching invoice details:', error));
  }, [id]);

  function formatDate(dateArray) {
    if (Array.isArray(dateArray) && dateArray.length === 3) {
      const [year, month, day] = dateArray;
      return `${day}/${month}/${year}`;
    }
    return '';
  }

  const handleBuyNow = async (productId, customerId) => {
    try {
      const transferUrl = `http://localhost:8080/api/products/${productId}/transfer/${customerId}`;
      const deleteInvoiceDetailsUrl = `http://localhost:8080/api/invoice-details/product/${productId}`;

      // Transfer the product
      const transferResponse = await fetch(transferUrl, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (!transferResponse.ok) {
        throw new Error('Failed to transfer product');
      }

      // Delete invoice details
      const deleteResponse = await fetch(deleteInvoiceDetailsUrl, {
        method: 'DELETE',
      });

      if (!deleteResponse.ok) {
        throw new Error('Failed to delete invoice details');
      }

      console.log('Product transferred and invoice details deleted successfully');
      navigate('/'); // Navigate to the desired route after successful operation
    } catch (error) {
      console.error('Error during transaction:', error);
    }
  };

  return (
    <div className='product-list'>
      <h1>Invoice Rent</h1>
      <table border='1'>
        <thead>
          <tr>
            <th>Product Name</th>
            <th>ProductId</th>
            <th>Cost</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {invoiceDetails.map(invoice => (
            <tr key={invoice.invDtlId}>
              <td>{invoice.product.productEnglishName}</td>
              <td>{invoice.product.productId}</td>
              <td>{invoice.basePrice}</td>
              <td>{formatDate(invoice.invoice.invoiceDate)}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <div>
        <br />
        <Button onClick={() => handleBuyNow(id, localStorage.getItem('customerId'))}>Buy Now</Button>
      </div>
    </div>
  );
}

export default InvoiceRent;
