import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Row, Col } from 'react-bootstrap';
import CustomCard from '../component/CustomCard';
import HeadingPage from '../component/HeadingPage';
import Searchbox from '../component/Searchbox';
import DropdownComponent from '../component/DropDown';

function CategoryPage() {
  const { id } = useParams();
  const [products, setProducts] = useState([]);
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(`http://localhost:8080/api/products/type/${id}`)
      .then(response => response.json())
      .then(data => setProducts(data))
      .catch(error => console.error('Error:', error));
  }, [id]);

  const handleGenreSelect = (data) => {
    setData(data); // Update products with the fetched data based on selected genre
    console.log(data[0].product.productEnglishName);
  };
  const [searchQuery, setSearchQuery] = useState('');

  
   function onchange(e){
    console.log(e.target.value)
    setSearchQuery(e.target.value);
   }
   const displayedProducts = (data.length > 0 ? data.map(item => item.product) : products)
    .filter(product =>
      product.productEnglishName.toLowerCase().includes(searchQuery.toLowerCase())
    );
  return (
    <div>
      <div style={{ marginLeft: "493px", marginTop: "33px" }}>
        {products.length > 0 && products[0].productType && (
          <HeadingPage title={products[0].productType.name} />
        )}
      </div>
      <div style={{ marginLeft: "493px", marginTop: "63px", display: "flex", flexDirection: "row", gap: "10px" }}>
        <Searchbox placeholder="search" onchange={onchange} />
        <DropdownComponent index={id} onSelect={handleGenreSelect} />
      </div>
      <Container>
        <Row>
          {displayedProducts.map((product, index) => (
            <Col md={4} key={index}>
              <CustomCard
                title={product.productEnglishName}
                content={product.content}
                imgSrc={product.productImage}
                id={product.productId}
                price={product.productSpCost}
                page="Category Page"
              />
            </Col>
          ))}
        </Row>
      </Container>
    </div>
  );
}

export default CategoryPage;
