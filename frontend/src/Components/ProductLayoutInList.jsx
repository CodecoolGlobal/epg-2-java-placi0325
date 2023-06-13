import { useState } from "react";
import Loading from "../Pages/Loading/Loading";
import "../ProductList.css"

const ProductLayoutInList = ( { product }) => {

    return (
        <div className="listitem">
            <p>{product.name} </p>
            <p>${product.price}</p>
        </div>
    );
}

export default ProductLayoutInList;