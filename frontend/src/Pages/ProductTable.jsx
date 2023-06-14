import { useNavigate } from "react-router-dom";
import ProductLayoutInList from "../Components/ProductLayoutInList";
import "../css/ProductList.css"

const ProductTable = ( { products } ) => {
  const navigate = useNavigate();

    return (
        <div className="ProductTable">
          <table>
            <thead>
              <tr>
                <th className="title">Products</th>
              </tr>
            </thead>
            <button onClick={()=> navigate("/newproduct")}> Add new product</button>
            <tbody className="productlistContainer">
              {products && products.map((product) => (
                <tr key={product.id}>
                 <td>
                 <ProductLayoutInList product={product} />
                  </td> 
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        )
}

export default ProductTable;