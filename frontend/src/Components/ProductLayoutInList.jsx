import { useState, useNavigate } from "react";
import Loading from "../Pages/Loading/Loading";
import "../ProductList.css"

const ProductLayoutInList = ( { product }) => {

    const navigate = useNavigate();

    return (
        <div className="listitem"  onClick={() => navigate(`products/${product.id}`)}>
            <p>{product.name} </p>
            <p>${product.price}</p>
        </div>
    );
}

export default ProductLayoutInList;