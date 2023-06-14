import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import Loading from "./Loading/Loading";
import "../css/ProductPage.css";


const ProductPage = () => {
  const [loading, setLoading] = useState(true);
  const [product, setProduct] = useState(null);
  const [image,setImage] = useState("");
  const { id } = useParams();

  const fetchProduct = (signal) => {
    return fetch(`/products/${id}`, { signal }).then((data) => data.json());
  };

  const apiKey="5d8459301e850d0d6eda8beeb0f09acf51106732f340862541c4f2a347f3eacc";

  const fetchImage = () => {
    return fetch(`https://serpapi.com/search.json?engine=google_images&q=${product.name}&api_key=${apiKey}`).then(response=>response.json()).then(data=>{
      console.log(data.images_results[0].original);
      setImage(data.images_results[0].original);
    });
  }

  const displayImage = ()=>{
    fetchImage();
  }

  useEffect(() => {
    const controller = new AbortController();
    fetchProduct(controller.signal).then((products) => {
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
      <div className="product">
        <img className="image" src={image} alt="image" />
        <h2 className="info">{product.name}</h2>
        <p className="info">{product.description}</p>
        <p className="info">{product.price}</p>
        <button onClick={()=>displayImage()}>PUSH</button>
      </div>
    </>
  );
};

export default ProductPage;
