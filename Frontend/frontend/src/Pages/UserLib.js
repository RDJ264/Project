import { useEffect, useState } from "react"
import HeadingPage from "../component/HeadingPage"
import { Container, Row, Col } from 'react-bootstrap';
import CustomCard from "../component/CustomCard";
function UserLib({ isLoggedIn }){
    const [product,setproduct]=useState([])
    useEffect(()=>{
        fetch('http://localhost:8080/api/products')
        .then(response => response.json())
        .then(data => setproduct(data))
        .catch(error => console.error('Error:', error));
    },[])
    return (
        <div>
            <HeadingPage title="Lent a book"></HeadingPage>
            {console.log(product)}
            <div>
            <div className='cards'>
                <Container>
                  <Row>
                    {product.map((product, index) => (
                      product.isLibrary?(
                      <Col md={4} key={index}>
                        <CustomCard
                          id={product.productId}
                          title={product.productEnglishName}
                          content={product.productDescriptionShort} // Adjusted for proper content
                          imgSrc={product.productImage}
                          price={product.productSpCost}
                          page="Lentpage"
                       />
                      </Col>):" "
                    ))}
                  </Row>
                </Container>
              </div>
            </div>
            </div>
    )
}
export default UserLib