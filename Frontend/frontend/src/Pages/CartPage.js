import { useState, useEffect } from "react";
import HeadingPage from '../component/HeadingPage';
import { Container, Row, Col, Alert } from 'react-bootstrap';
import CustomCard from '../component/CustomCard';

function CartPage() {
    const [cartDetails, setCartDetails] = useState([]);
    const [totalPrice, setTotalPrice] = useState(0);

    useEffect(() => {
        fetchCartDetails();
    }, []);

    const fetchCartDetails = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/cartDetails/customer/${localStorage.getItem('customerId')}`);
            const data = await response.json();
            setCartDetails(data);
            const total = data.reduce((acc, item) => acc + item.product.productSpCost, 0);
            setTotalPrice(total);
        } catch (error) {
            console.error('Error:', error);
        }
    };

    const handleDelete = async (cartdetailsId) => {
        try {
            const response = await fetch(`http://localhost:8080/api/cartDetails/${cartdetailsId}`, {
                method: 'DELETE',
            });
            if (response.ok) {
                fetchCartDetails(); // Refresh cart details after deletion
                console.log('Product removed from cart successfully');
            } else {
                console.error('Failed to remove product from cart');
                const errorData = await response.text();
                console.error('Delete Error details:', errorData);
            }
        } catch (error) {
            console.error('Delete Request Error:', error);
        }
    };

    return (
        <div>
            <div style={{ marginLeft: "493px", marginTop: "33px" }}>
                <HeadingPage title="Cart Details" />
            </div>
            <div className='cards'>
                <Container>
                    <Row>
                        {cartDetails.map((product, index) => (
                            <Col md={4} key={index}>
                                <CustomCard
                                    title={product.product.productEnglishName}
                                    content={product.product.productDescriptionShort}
                                    imgSrc={product.product.productImage}
                                    price={product.product.productSpCost}
                                    cartdetailsid={product.id} // Pass cartdetailsid to CustomCard
                                    onDelete={() => handleDelete(product.ctid)} // Pass handleDelete function
                                    page="Cart Page"
                                />
                            </Col>
                        ))}
                    </Row>
                </Container>
            </div>
            <div style={{ marginTop: "20px", marginLeft: "93px" }}>
                <Alert variant="info">
                    <h4>Total Price: {totalPrice}</h4>
                </Alert>
            </div>
        </div>
    );
}

export default CartPage;
