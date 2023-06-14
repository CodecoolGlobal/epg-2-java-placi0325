import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Loading from "../Pages/Loading/Loading";
import "../css/ProductList.css"

const ProductLayoutInList = ( { product }) => {

    const navigate = useNavigate();

    return (
        <div className="listitem"  onClick={() => navigate(`/products/${product.id}`)}>
            <p>{product.name} </p>
            <p>${product.price}</p>
        </div>
    );
}

export default ProductLayoutInList;