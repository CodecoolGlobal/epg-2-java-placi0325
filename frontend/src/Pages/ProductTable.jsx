import ProductLayoutInList from "../Components/ProductLayoutInList";
import "../ProductList.css"

const ProductTable = ( { products } ) => {

    return (
        <div className="ProductTable">
          <table>
            <thead>
              <tr>
                <th className="title">Products</th>
              </tr>
            </thead>
            <tbody className="productlistContainer">
              {products.map((product) => (
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