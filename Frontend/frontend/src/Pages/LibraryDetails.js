import HeadingPage from '../component/HeadingPage'
import { useEffect, useState } from "react"
import { Container, Row, Col } from 'react-bootstrap';
import CustomCard from '../component/CustomCard';
function LibraryDetails(){
    const [shelfdteails,setShelfDetails]=useState([])
    const [libpackage,showlibpackage]=useState([])
    useEffect(()=>{
        fetch(`http://localhost:8080/api/products-on-shelf/customer/${localStorage.getItem('customerId')}`).then(res=>res.json()).then(data=>setShelfDetails(data))
    },[])
    useEffect(()=>{
        fetch(`http://localhost:8080/api/customers/${localStorage.getItem('customerId')}`).then(res=>res.json()).then(data=>showlibpackage(data.libraryPackage))
    },[])
    const [lib,setlib]=useState([])
    useEffect(()=>{
      fetch(`http://localhost:8080/api/customers/${localStorage.getItem('customerId')}`).then(res=>res.json()).then(res1=>setlib(res1.libraryPackage))
    },[])
    const [expirydate,setexpirydate]=useState("")
    useEffect(()=>{
      fetch(`http://localhost:8080/api/customers/${localStorage.getItem('customerId')}`).then(res=>res.json()).then(data=>setexpirydate(data.registrationDate))
    },[])
    function formatDate(dateArray) {
      if (Array.isArray(dateArray) && dateArray.length === 3) {
        const [year, month, day] = dateArray;
        return `${day}/${month}/${year}`;
      }
      return '';
    }
    return(
        <div>
          {console.log("date=",formatDate(expirydate))}
            {console.log(libpackage)}
        <div style={{ marginLeft: "393px", marginTop: "593px" }}>
            <HeadingPage title="My Library"></HeadingPage>
        </div>
        <div>
          {libpackage!=null?
            <table border="1">
                <tr>
                <th>Name</th>
                <th>Days</th>
                <th>Cost</th>
                </tr>
                                        <tr>
<td>{libpackage.name}</td>
<td>{libpackage.days}</td>
<td>{libpackage.cost}</td>
                </tr>
                
                {console.log(shelfdteails)}

            </table>:<h4>No package purchased</h4>
}</div>
        <div className='cards'>
            {
            
            <Container>
              <Row>
                {shelfdteails.map((product, index) => (
                  product.tranType=="L"||product.tranType=="R"?
                  <Col md={4} key={index}>
                    <CustomCard
                      title={product.product.productEnglishName}
                      content={product.product.productDescriptionShort} // Adjusted for proper content
                      imgSrc={product.product.productImage}
                      price={product.product.productSpCost}
                      transtype={product.tranType}
                      expirydate={formatDate(expirydate)} 
                      rentexpiry={formatDate(product.rentexpirydate)}
                   />
                  </Col>:""
                ))}
              </Row>
            </Container>
            }
</div>
    </div>
    )
}
export default LibraryDetails