import { useEffect, useState } from "react"
import HeadingPage from "../component/HeadingPage"
import CustomCard from "../component/CustomCard"
import { Container, Row, Col } from 'react-bootstrap';
function MyShelf(){
    const [shelfdteails,setShelfDetails]=useState([])
    useEffect(()=>{
        fetch(`http://localhost:8080/api/products-on-shelf/customer/${localStorage.getItem('customerId')}`).then(res=>res.json()).then(data=>setShelfDetails(data))
    },[])
    return(
        <div>
            <div style={{ marginLeft: "393px", marginTop: "593px" }}>
                <HeadingPage title="My Shelf"></HeadingPage>
            </div>
            {console.log(shelfdteails)}
            <div className='cards'>
                <Container>
                  <Row>
                    {shelfdteails.map((product, index) => (
                      <Col md={4} key={index}>
                        <CustomCard
                          title={product.product.productEnglishName}
                          content={product.product.productDescriptionShort} // Adjusted for proper content
                          imgSrc={product.product.productImage}
                          price={product.product.productSpCost}
                          transtype={product.tranType}
                       />
                      </Col>
                    ))}
                  </Row>
                </Container>
              </div>
        </div>
    )
}
export default MyShelf