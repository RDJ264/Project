import { useParams } from 'react-router-dom';
import {useEffect,useState} from "react"
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function InvoiceRent(){
    const navigate = useNavigate();
    const [invoicedetails,setinvoicedetails]=useState([])
    const { id } = useParams();
   useEffect(()=>{
     fetch(`http://localhost:8080/api/invoice-details/product/${id}`).then(res=>res.json()).then(data=>setinvoicedetails(data))
   },[])
   function formatDate(dateArray) {
    if (Array.isArray(dateArray) && dateArray.length === 3) {
      const [year, month, day] = dateArray;
      return `${day}/${month}/${year}`;
    }
    return '';
  }
  const addtoshelf=async(id,customerid)=>{
    try{
        const response=await fetch(`http://localhost:8080/api/products/${id}/transfer/${customerid}`,{
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
        });
        if(response.ok){
          console.log("added product"+id+"to rent successfully")
        navigate(`/`)
        }
      }
      catch(error){
        console.log(error)
      }
  }
    return(
        <div className='product-list'>
        {console.log(invoicedetails)}
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
          {invoicedetails.map(invoice => (
              <tr key={invoice.invDtlId}>
                <td>{invoice.product.productEnglishName}</td>
                <td>{invoice.product.productId}</td>
                <td>{invoice.basePrice
                }</td>
                <td>{formatDate(invoice.invoice.invoiceDate)}</td>
              </tr> 
          ))}
        </tbody>
      </table>
      <div>
        <br></br>
      <Button onClick={()=>addtoshelf(id,localStorage.getItem('customerId'))}>Buy Now</Button>
      </div>
        </div>
    )
}
export default InvoiceRent