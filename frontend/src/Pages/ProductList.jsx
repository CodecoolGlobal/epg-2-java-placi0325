import { useEffect, useState } from "react";
import Loading from "./Loading/Loading";
import ProductTable from "./ProductTable";
import "../ProductList.css"

const fetchProducts = (signal) => {
  return fetch("/products/available", { signal }).then((res) => res.json());
};

const ProductList = () => {
    const [loading, setLoading] = useState(true);
    const [data, setData] = useState(null);
 

  useEffect(() => {
    const controller = new AbortController();

    fetchProducts(controller.signal)
      .then((products) => {
        setLoading(false);
        setData(products);
      })
      .catch((error) => {
        if (error.name !== "AbortError") {
          setData(null);
          throw error;
        }
      });

    return () => controller.abort();
  }, []);

  if (loading) {
    return <Loading />;
  }

  return <div>
    <ProductTable products={data}/>
  </div>;
};

export default ProductList;
