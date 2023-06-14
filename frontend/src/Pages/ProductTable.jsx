import ProductLayoutInList from "../Components/ProductLayoutInList";
import "../css/ProductList.css";
import Header from "../Components/Header"


const ProductTable = ({ products }) => {
  

  return (
    <div className="ProductTable">
    <Header />
    <table>
      <thead>
        
      </thead>
      <tbody className="productlistContainer">
        {products &&
          products.map((product) => (
            <tr key={product.id}>
              <td>
                <div className="listitem">
                  <ProductLayoutInList product={product} />
                </div>
              </td>
            </tr>
          ))}
      </tbody>
    </table>
  </div>
  );
};

export default ProductTable;
