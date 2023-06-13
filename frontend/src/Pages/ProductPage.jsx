import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import Loading from "./Loading/Loading";


const ProductPage = () => {
  const [loading, setLoading] = useState(true);
  const [product, setProduct] = useState(null);
  const { id } = useParams();

  const fetchProduct= (signal)=>{
        return fetch(`/products/${id}`,{signal}).then(data => data.json());
  }
  
  useEffect(() => {
    const controller = new AbortController();

    fetchProduct(controller.signal)
      .then((products) => {
        setLoading(false);
        setProduct(products);
      })
      .catch((error) => {
        if (error.name !== "AbortError") {
          setProduct(null);
          throw error;
        }
      });

    return () => controller.abort();
  }, []);

  if (loading) {
    return <Loading />;
  }

  return (
    <>
        <div>
          <p>{product.name}</p>
          </div>    
    </>
  );
};

export default ProductPage;
